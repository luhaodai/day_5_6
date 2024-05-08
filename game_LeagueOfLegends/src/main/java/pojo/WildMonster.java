package pojo;

public class WildMonster extends Things{
    public boolean is_alive=true;

    public double blood;//血量

    public WildMonster(String name, int attack, int defense, int money,int blood) {
        super(name, attack, defense, money);
        this.blood = blood;
    }
}
