package hard.string.entity;

import hard.string.entity.cards.Monster.Monster;
import org.springframework.stereotype.Component;

import javax.persistence.*;



public class Player{

    //playerId == userId
    private long playerId;


    private TempDeck tempDeck;
    private TempHand tempHand;

    private MonsterField monsterField;

    private int activeTaunt;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMonsterField(MonsterField monsterField) {
        this.monsterField = monsterField;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public void setTempDeck(TempDeck tempDeck) {
        this.tempDeck = tempDeck;
    }

    public String getUsername() {
        return username;
    }

    public long getPlayerId() {
        return playerId;
    }

    public MonsterField getMonsterField() {
        return monsterField;
    }

    public TempDeck getTempDeck() {
        return tempDeck;
    }

    public void setTempHand(TempHand tempHand) {
        this.tempHand = tempHand;
    }

    public TempHand getTempHand() {
        return tempHand;
    }

    public int getActiveTaunt() {
        return activeTaunt;
    }

    public void setActiveTaunt(int activeTaunt) {
        this.activeTaunt = activeTaunt;
    }
}
