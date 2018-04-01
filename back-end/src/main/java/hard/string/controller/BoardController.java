package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.service.*;
import hard.string.entity.*;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

/**
 * Created by Teama on 3/24/2018.
 */

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardDBRepository boardDBRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private MonsterService monsterService;

    @Autowired
    private BoardDBService boardDBService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private RunningGameService runningGameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MonsterFieldService monsterFieldService;

    @RequestMapping(method = RequestMethod.GET, params = {"userId"})
    public ResponseEntity getBoard(
            @RequestParam Long userId
    ){
        Long gameId = boardDBService.findBoard(userId);
        if(gameId > 0){
            Board game = runningGameService.getGame(gameId);
            return ResponseEntity.ok(new BoardDto(game,boardService.getPlayer(userId,game),boardService.getEnemeyPlayer(userId,game)));
        }
        else{
            return ResponseEntity.badRequest().body("No game found!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/attack"}, params = {"player1","player2","monster1","monster2"})
    public ResponseEntity attack(
            @RequestParam Long player,
            @RequestParam int monster1,
            @RequestParam int monster2
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(player,player).getBoardId();
        Board board = runningGameService.getGame(gameId);
        boolean valid;
        valid = boardService.isValidTurn(boardService.getPlayer(player,board),board);
        //if the turn is valid
        if(valid) {
            //get currentPlayer
            Player p1 = boardService.getPlayer(player,board);
            //get enemyPlayer
            Player p2 = boardService.getEnemeyPlayer(player,board);
            TempMonster m1 = monsterFieldService.getMonster(monster1, p1.getMonsterField());
            TempMonster m2 = monsterFieldService.getMonster(monster2, p2.getMonsterField());
            boardService.fight(p1, p2, m1, m2, monster1, monster2);
            boardService.isGameEnd(board);
            return ResponseEntity.ok(new BoardDto(board, p1, p2));
        }
        else{
            return ResponseEntity.badRequest().body("Not your turn");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value={"/endturn"})
    public ResponseEntity endturn(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player currentPlayer = boardService.getPlayer(userId,board);
        boolean valid = boardService.isValidTurn(currentPlayer,board);
        if(valid) {
            boardService.endTurn(board);
            Player enemyPlayer = boardService.getEnemeyPlayer(userId, board);
            playerService.drawCard(enemyPlayer);
            return ResponseEntity.ok(new BoardDto(board, currentPlayer, enemyPlayer));
        }
        return ResponseEntity.badRequest().body("Not your fucking turn you twat");
    }

    @RequestMapping(method = RequestMethod.GET, value={"/currentmana"})
    public ResponseEntity getCurrentMana(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getPlayer(userId,board);
        if(board.getPlayer1().equals(p)){
            return ResponseEntity.ok(board.getMana1());
        }
        return ResponseEntity.ok(board.getMana2());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/enemymana"})
    public ResponseEntity getEnemyMana(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getPlayer(userId,board);
        if(board.getPlayer1().equals(p)){
            return ResponseEntity.ok(board.getMana2());
        }
        return ResponseEntity.ok(board.getMana1());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/currentmonsterfield"})
    public ResponseEntity getCurrentMonsterField(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getPlayer(userId,board);
        return ResponseEntity.ok(p.getMonsterField());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/enemymonsterfield"})
    public ResponseEntity getEnemyMonsterField(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getEnemeyPlayer(userId,board);
        return ResponseEntity.ok(p.getMonsterField());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/currentdeck"})
    public ResponseEntity getCurrentDeck(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getPlayer(userId,board);
        return ResponseEntity.ok(p.getTempDeck().getCards().size());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/enemydeck"})
    public ResponseEntity getEnemyDeck(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p = boardService.getEnemeyPlayer(userId,board);
        return ResponseEntity.ok(p.getTempDeck().getCards().size());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/validmonsterfield"})
    public ResponseEntity getValidMonsterField(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p1 = boardService.getPlayer(userId,board);
        Player p2 = boardService.getEnemeyPlayer(userId,board);
        return ResponseEntity.ok(new BoardDto(board,p1,p2).getAvailableMonsterField());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/validmagictaget"})
    public ResponseEntity getValidMagicTarget(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p1 = boardService.getPlayer(userId,board);
        Player p2 = boardService.getEnemeyPlayer(userId,board);
        return ResponseEntity.ok(new BoardDto(board,p1,p2).getAvailableMagicTarget());
    }

}
