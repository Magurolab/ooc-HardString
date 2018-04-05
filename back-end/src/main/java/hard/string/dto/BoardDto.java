package hard.string.dto;

import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.service.BoardService;
import hard.string.service.CardService;
import hard.string.service.MonsterFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/25/2018.
 */

public class BoardDto {

    private int currentPlayerMana;
    private int maxCurrentPlayerMana;
    private int enemyPlayerMana;
    private int maxEnemyPlayerMana;

    private long currentPlayer;
    private MonsterField currentField;
    private List<CardDto> currentHand;
//    private TempHand currentHand;
    private long currentDeck;
    private String yourUsername;

    private long enemyPlayer;
    private MonsterField enemyField;
    private int enemyHand;
    private long enemyDeck;
    private String enemyUsername;

    //valid space to play monster
    private List<String> availableMonsterField;

    //valid space to play magic
    private List<String> availableMagicTarget;

    //valid attack target
    private List<String> availableAttackTarget;

    private boolean turn;
    private boolean gameOver;

    private void createCurrentHand(TempHand tempHand, CardService cardService){
        currentHand = cardService.createHandDto(tempHand);
    }

    private void createField(Player currentPlayer, Player enemyPlayer, MonsterFieldService monsterFieldService){
        availableMonsterField = new ArrayList<>();
        availableMagicTarget = new ArrayList<>();
        availableAttackTarget = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            if(monsterFieldService.checkMonster(i,currentPlayer.getMonsterField())){
                availableMagicTarget.add(String.valueOf(i)+'P');
            }
            else{
                availableMonsterField.add(String.valueOf(i)+'P');
            }
        }
        for(int i = 0; i < 6; i++){
            boolean isValid = monsterFieldService.checkMonster(i, enemyPlayer.getMonsterField());
            if(isValid){
                availableMagicTarget.add(String.valueOf(i)+'E');
                availableAttackTarget.add(String.valueOf(i)+'E');
            }
        }
    }

    public BoardDto(Board board, Player currentPlayer, Player enemyPlayer,
                    BoardService boardService,
                    MonsterFieldService monsterFieldService,
                    CardService cardService){
        this.maxCurrentPlayerMana = boardService.getMaxMana(currentPlayer.getPlayerId(),board);
        this.maxEnemyPlayerMana = boardService.getMaxMana(enemyPlayer.getPlayerId(),board);
        currentPlayerMana = boardService.getCurrentMana(currentPlayer.getPlayerId(),board);
        maxEnemyPlayerMana = boardService.getCurrentMana(enemyPlayer.getPlayerId(),board);
        this.currentPlayer = currentPlayer.getPlayerId();
        this.enemyPlayer = enemyPlayer.getPlayerId();
        currentField = currentPlayer.getMonsterField();
        enemyField = enemyPlayer.getMonsterField();
        createCurrentHand(currentPlayer.getTempHand(),cardService);
//        currentHand = currentPlayer.getTempHand();
        enemyHand = enemyPlayer.getTempHand().getHand().size();
        currentDeck = currentPlayer.getTempDeck().getCards().size();
        enemyDeck = enemyPlayer.getTempDeck().getCards().size();
        yourUsername = currentPlayer.getUsername();
        enemyUsername = enemyPlayer.getUsername();
        turn = boardService.isValidTurn(currentPlayer,board);
        gameOver = board.isGameIsOver();
        createField(currentPlayer,enemyPlayer,monsterFieldService);
    }

    public List<String> getAvailableAttackTarget() {
        return availableAttackTarget;
    }

    public int getCurrentPlayerMana() {
        return currentPlayerMana;
    }

    public int getEnemyPlayerMana() {
        return enemyPlayerMana;
    }

    public boolean isTurn() {
        return turn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public long getEnemyPlayer() {
        return enemyPlayer;
    }

    public long getCurrentPlayer() {
        return currentPlayer;
    }

    public int getEnemyHand() {
        return enemyHand;
    }

    public long getCurrentDeck() {
        return currentDeck;
    }

    public long getEnemyDeck() {
        return enemyDeck;
    }

    public MonsterField getCurrentField() {
        return currentField;
    }

    public MonsterField getEnemyField() {
        return enemyField;
    }

    public String getYourUsername() {
        return yourUsername;
    }

    public String getEnemyUsername() {
        return enemyUsername;
    }

    public List<CardDto> getCurrentHand() {
        return currentHand;
    }

    public int getMaxCurrentPlayerMana() {
        return maxCurrentPlayerMana;
    }

    public int getMaxEnemyPlayerMana() {
        return maxEnemyPlayerMana;
    }


    //    public TempHand getCurrentHand() {
//        return currentHand;
//    }

    public List<String> getAvailableMonsterField() {
        return availableMonsterField;
    }

    public List<String> getAvailableMagicTarget() {
        return availableMagicTarget;
    }


}

