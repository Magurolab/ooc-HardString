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
//            @RequestParam String currentmonster,
            @RequestParam Integer currentmonster,
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
            int currentin = currentmonster;
            System.out.println("Our monster position :" + currentmonster);
            System.out.println("Attempt to attack : " + enemymonster);
            Player p1 = boardService.getPlayer(userWithProfileDto.getUserId(),board);
            //get enemyPlayer
            Player p2 = boardService.getEnemeyPlayer(userWithProfileDto.getUserId(),board);
            char side = enemymonster.charAt(enemymonster.length() - 1);
            int in = Integer.valueOf(enemymonster.subSequence(0, enemymonster.length() - 1).toString());
            if(side == 'E'){
                System.out.println("Justified enemy position");
                TempMonster m1 = monsterFieldService.getMonster(currentin, p1.getMonsterField());
                TempMonster m2 = monsterFieldService.getMonster(in, p2.getMonsterField());
                System.out.println("Your monster can attack : " + m1.isCanAttack());
                if(m1.isCanAttack()) {
                    boardService.fight(p1, p2, m1, m2, currentin, in);
                    boardService.gameEndHandler(board);
                }
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

    @RequestMapping(method = RequestMethod.POST, value={"/ragequit"})
    public ResponseEntity ragequit(
            Authentication authentication
    ){
        UserWithProfileDto userWithProfileDto = (UserWithProfileDto) authentication.getPrincipal();
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(userWithProfileDto.getUserId(),userWithProfileDto.getUserId()).getBoardId();
        Board board = runningGameService.getGame(gameId);
        board.setGameIsOver(true);
        boardService.gameEndHandler(board);
        return ResponseEntity.ok().body("someone rage quit");
    }

}
