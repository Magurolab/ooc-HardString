package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.dto.UserWithProfileDto;
import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.CardRepository;
import hard.string.repository.MagicRepository;
import hard.string.repository.MonsterRepository;
import hard.string.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    private MonsterFieldService monsterFieldService;
    @Autowired
    private CardService cardService;
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
            Authentication authentication
    ){
        UserWithProfileDto userWithProfileDto = (UserWithProfileDto) authentication.getPrincipal();
        Long gameId = boardDBService.findBoard(userWithProfileDto.getUserId());
        if(gameId > 0){
            Board game = runningGameService.getGame(gameId);
//            return ResponseEntity.ok(new BoardDto(game,boardService.getPlayer(playerId,game),boardService.getEnemeyPlayer(playerId,game)));
            return ResponseEntity.ok(boardService.getPlayer(userWithProfileDto.getUserId(),game).getTempHand().getHand());
        }
        else{
            return ResponseEntity.badRequest().body("No game found!");
        }
    }

    /**
     * Check if player can play the card
     * @param authentication id of the current player
     * @param cardId card that is going to be play
     * @param index index on the board that the card is going to
     * @return response code, and the updated board
     */
    @RequestMapping(method = RequestMethod.POST, value = "/usecard")
    public ResponseEntity useCard(
            Authentication authentication,
            @RequestParam long cardId,
            @RequestParam String index
    ){
        UserWithProfileDto userWithProfileDto = (UserWithProfileDto) authentication.getPrincipal();
        Card playedCard = cardRepository.findById(cardId).orElse(null);
        Board board = runningGameService.getGame(boardDBService.findBoard(userWithProfileDto.getUserId()));
        Player currentPlayer = boardService.getPlayer(userWithProfileDto.getUserId(),board);
        Player enemyPlayer = boardService.getEnemeyPlayer(userWithProfileDto.getUserId(),board);
        //check if the card is valid in database
        if(playedCard!=null){
            //check if player is able to play this card
            if(boardService.canPlayThisCard(board,playedCard,currentPlayer)) {
                char side = index.charAt(index.length() - 1);
                int in = Integer.valueOf(index.subSequence(0, index.length() - 1).toString());
                if (side == 'P') {
                    tempHandService.playCard(board, currentPlayer, playedCard, in, true);
                    if (boardService.isGameEnd(board)){

                        //do something with the game
                    }
                    return ResponseEntity.ok().body(new BoardDto(board,currentPlayer,enemyPlayer
                            ,boardService,monsterFieldService,cardService));
                } else if (side == 'E') {
                    tempHandService.playCard(board, currentPlayer, playedCard, in, false);

                    boardService.isGameEnd(board);

                    return ResponseEntity.ok().body(new BoardDto(board,currentPlayer,enemyPlayer
                            ,boardService,monsterFieldService,cardService));
                } else {
                    //shouldn't go here
                    return ResponseEntity.badRequest().body("Something weird happen");
                }
            }
            return ResponseEntity.badRequest().body("Invalid turn!");
        }
        return ResponseEntity.badRequest().body("Not a valid card");
    }

}
