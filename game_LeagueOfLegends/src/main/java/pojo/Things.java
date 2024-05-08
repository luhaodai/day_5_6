package pojo;

public class Things {
    //    名字
    public String name;
    //    攻击力
    public int attack;
    //    防御力
    public int defense;
    public int money;

    public Things() {
    }

    public Things(String name, int attack, int defense,int money) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.money = money;
    }
}
