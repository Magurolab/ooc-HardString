package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.CardRepository;
import hard.string.repository.MagicRepository;
import hard.string.repository.MonsterRepository;
import hard.string.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 3/17/2018.
 */

@RestController
@RequestMapping("/hand")
public class HandController {

    @Autowired
    private BoardDBRepository boardDBRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MonsterRepository monsterRepository;
    @Autowired
    private MagicRepository magicRepository;

    @Autowired
    private BoardDBService boardDBService;
    @Autowired
    private TempMonsterService tempMonsterService;
    @Autowired
    private TempHandService tempHandService;
    @Autowired
    private RunningGameService runningGameService;
    @Autowired
    private BoardService boardService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity update(
            @RequestParam long playerId
    ){
        Long gameId = boardDBService.findBoard(playerId);
        if(gameId > 0){
            Board game = runningGameService.getGame(gameId);
            return ResponseEntity.ok(new BoardDto(game,boardService.getPlayer(playerId,game),boardService.getEnemeyPlayer(playerId,game)));
        }
        else{
            return ResponseEntity.badRequest().body("No game found!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/useCard")
    public ResponseEntity useCard(
            @RequestParam long playerId,
            @RequestParam long cardId,
            @RequestParam String index
    ){
        Card playedCard = cardRepository.findById(cardId).orElse(null);
        Board board = runningGameService.getGame(boardDBService.findBoard(playerId));
        if(playedCard!=null){
            char side = index.charAt(index.length()-1);
            int in = Integer.valueOf(index.subSequence(0,index.length()-1).toString());
            if(side=='P'){
                tempHandService.playCard(board,boardService.getPlayer(playerId,board),playedCard,in,true);
            }
            else if(side=='E'){
                tempHandService.playCard(board,boardService.getPlayer(playerId,board),playedCard,in,false);
            }
            else{
                //shouldn't go here
                return ResponseEntity.badRequest().body("Invalid card!");
            }
        }

        return null;
    }

}
