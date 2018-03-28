package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.service.*;
import hard.string.entity.*;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private MonsterService monsterService;

    @Autowired
    private BoardDBService boardDBService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private RunningGameService runningGameService;

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
            @RequestParam Long player2,
            @RequestParam Long player1,
            @RequestParam int monster1,
            @RequestParam int monster2
    ){
        long gameId = boardDBRepository.findByPlayer1OrPlayer2(player1,player2).getBoardId();
        Board game = runningGameService.getGame(gameId);
        Player p1 = boardService.getPlayer(player1,game);
        Player p2 = boardService.getPlayer(player2,game);
        TempMonster m1 = monsterFieldService.getMonster(monster1,p1.getMonsterField());
        TempMonster m2 = monsterFieldService.getMonster(monster2,p2.getMonsterField());
        boardService.fight(p1,p2,m1,m2,monster1,monster2);
        return ResponseEntity.ok(new BoardDto(game,p1,p2));
    }
}
