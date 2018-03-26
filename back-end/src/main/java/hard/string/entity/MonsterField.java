package hard.string.entity;


import javax.persistence.*;
import java.util.ArrayList;


//Monster on the field for such player
@Entity
public class MonsterField {
    @Id
    private int fieldID;
    @GeneratedValue

    private int monsterNum;


    @OneToOne
    @JoinColumn(name = "monster_field_owner")
    private Player monsterFieldOwner;

    @Column(name = "monster_field_temp_monster_id")
    private long tempMonsterID;
    @OneToOne(mappedBy = "tempMonsterOwner")
    private TempMonsters tempMonsters;

    //TODO Chaged to static array for position manipulation.
    private int tauntNum;
    private final int MAXCARD = 6; //1 Player 5 Monster


//    public MonsterField() {
//        this.field = new ArrayList<>();
//        tauntNum = 0;
//    }
//
//    private Integer[] getAllSlot(){
//        return new Integer[] {m0ID,m1ID,m2ID,m3ID,m4ID};
//    }
//
//    public boolean addMonster(Monster monster,int slotIndex){
//        Integer[] allSlot = getAllSlot();
//        Integer slot = allSlot[slotIndex];
//        if(slot != null){
//            slot = monster.;
//            if(slot.isTaunt()){
//                tauntNum++;
//            }
//            return true;
//        }else {
//            //ลงไม่ได้
//            return false;
//        }
//
//    }
//    public void remove(Monster monster){
//        Monster[] allSlot = getAllSlot();
//        Monster slot;
//        for(int i =0;i<allSlot.length;i++){
//            slot = allSlot[i];
//            if(slot.getId().equals(monster.getId()) &&
//                    slot.getHp() == monster.getHp() &&
//                    slot.getAtk() == monster.getAtk()){
//                slot = null;
//            }
//        }
//        if(monster.isTaunt()){
//            tauntNum--;
//        }
//
//    }
//
//    //    @Column(name = "taunt_num", length = 100)
//    public int getTauntNum(){
//        return tauntNum;
//    }
//
//
////    @Column(name = "UserName", length = 100)
//
//
//    public Monster[] getField() {
//        return new Monster[] {p,m0,m1,m2,m3,m4} ;
//    }
//
//
//    public void setTauntNum(int tauntNum) {
//        this.tauntNum = tauntNum;
//    }
}
