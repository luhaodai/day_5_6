package pojo;

public class Weapon extends Things{
    public static int weaponMinimumIndex;
    public static int weaponMaxIndex;


    //    名字
//    public String name;
////    攻击力
//    public int attack;
////    防御力
//    public int defense;
    public boolean haveOwner=false;
//    给英雄增加的血量
    public int addBloodToHero;

    public Weapon(){
        super();
    }


    public Weapon(String name, int attack, int defense, int money,int addBloodToHero) {
        super(name, attack, defense,money);
        this.addBloodToHero = addBloodToHero;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "addBloodToHero=" + addBloodToHero +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", money=" + money +
                '}';
    }
}
