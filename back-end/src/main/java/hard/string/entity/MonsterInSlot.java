package hard.string.entity;

import hard.string.entity.cards.Monster.Monster;

public class MonsterInSlot {

    private int slotNum;
    private Monster monster;

    public MonsterInSlot(int slotNum, Monster monster) {
        this.slotNum = slotNum;
        this.monster = monster;
    }

    public boolean compareMonster(Monster m){
        return monster.equals(m);
//        return monster.getAtk() == m.getAtk() &&
//                monster.getHp() == m.getHp() &&
//                monster.getId().equals(m.getId());
    }

    public int getSlotNum() {
        return slotNum;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
