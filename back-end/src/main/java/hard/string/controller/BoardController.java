package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.dto.UserWithProfileDto;
import hard.string.service.*;
import hard.string.entity.*;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    private CardService cardService;

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getBoard(
            Authentication authentication
    ){
        UserWithProfileDto currentUser = (UserWithProfileDto) authentication.getPrincipal();
        Long gameId = boardDBService.findBoard(currentUser.getUserId());
        if(gameId > 0){
            Board game = runningGameService.getGame(gameId);
            return ResponseEntity.ok(new BoardDto(game,boardService.getPlayer(currentUser.getUserId(),game),boardService.getEnemeyPlayer(currentUser.getUserId(),game)
                    ,boardService,monsterFieldService,cardService));
        }
        else{
            return ResponseEntity.badRequest().body("No game found!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/attack"})
    public ResponseEntity attack(
            Authentication authentication,
            @RequestParam String currentmonster,
            @RequestParam String enemymonster
    ){
        UserWithProfileDto userWithProfileDto = (UserWithProfileDto) authentication.getPrincipal();
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userWithProfileDto.getUserId(),userWithProfileDto.getUserId()).getBoardId();
        Board board = runningGameService.getGame(gameId);
        boolean valid;
        valid = boardService.isValidTurn(boardService.getPlayer(userWithProfileDto.getUserId(),board),board);
        //if the turn is valid
        if(valid) {
            //get currentPlayer
            int currentin = Integer.valueOf(currentmonster.subSequence(0,currentmonster.length()-1).toString());
            Player p1 = boardService.getPlayer(userWithProfileDto.getUserId(),board);
            //get enemyPlayer
            Player p2 = boardService.getEnemeyPlayer(userWithProfileDto.getUserId(),board);
            char side = enemymonster.charAt(enemymonster.length() - 1);
            int in = Integer.valueOf(enemymonster.subSequence(0, enemymonster.length() - 1).toString());
            if(side == 'E'){
                TempMonster m1 = monsterFieldService.getMonster(currentin, p1.getMonsterField());
                TempMonster m2 = monsterFieldService.getMonster(in, p2.getMonsterField());
                boardService.fight(p1, p2, m1, m2, currentin, in);
                boardService.gameEndHandler(board);
                return ResponseEntity.ok(new BoardDto(board, p1, p2
                        , boardService, monsterFieldService, cardService));
            }
            return ResponseEntity.badRequest().body("Invalid enemy monster");
        }
        else{
            return ResponseEntity.badRequest().body("Not your turn");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value={"/endturn"})
    public ResponseEntity endturn(
            Authentication authentication
    ){
        UserWithProfileDto userWithProfileDto = (UserWithProfileDto) authentication.getPrincipal();
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userWithProfileDto.getUserId(),userWithProfileDto.getUserId()).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player currentPlayer = boardService.getPlayer(userWithProfileDto.getUserId(),board);
        boolean valid = boardService.isValidTurn(currentPlayer,board);
        if(valid) {
            boardService.endTurn(board);
            Player enemyPlayer = boardService.getEnemeyPlayer(userWithProfileDto.getUserId(), board);
            playerService.drawCard(enemyPlayer);
            boardService.gameEndHandler(board);
            return ResponseEntity.ok(new BoardDto(board, currentPlayer, enemyPlayer
                    ,boardService,monsterFieldService,cardService));
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
        return ResponseEntity.ok(new BoardDto(board,p1,p2
                ,boardService,monsterFieldService,cardService).getAvailableMonsterField());
    }

    @RequestMapping(method = RequestMethod.GET, value={"/validmagictaget"})
    public ResponseEntity getValidMagicTarget(
            @RequestParam Long userId
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userId,userId).getBoardId();
        Board board = runningGameService.getGame(gameId);
        Player p1 = boardService.getPlayer(userId,board);
        Player p2 = boardService.getEnemeyPlayer(userId,board);
        return ResponseEntity.ok(new BoardDto(board,p1,p2
                ,boardService,monsterFieldService,cardService).getAvailableMagicTarget());
    }

}
