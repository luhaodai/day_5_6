package pojo;

public class Hero extends Things{
//    英雄将要装备武器的数组下标
    public int weaponsIndex=0;
    public boolean is_alive=true;
    public boolean is_used=false;
//    姓名
//    public String name;
//
////    三属性
////    血量
    public double blood;
////    自带攻击力
//    public int attack;
////    自带防御力
//    public int defense;


//    暴击
    public int criticalStrike;

//    武器
    public Weapon[] weapons;
    public Product[] bag;
    public Hero() {

    }

    public Hero(String name, int attack, int defense,int blood,int money) {
        super(name, attack, defense,money);

        this.blood = blood;

//        将武器数组变为空一个英雄的武器最多为9件
        weapons=new Weapon[9];
    }
}
