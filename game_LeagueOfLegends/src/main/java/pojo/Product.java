package pojo;

public class Product extends Things {
    public int addBlood;
    public boolean is_used=false;

    public Product(String name, int attack, int defense, int money,int addBlood) {
        super(name, attack, defense, money);
        this.addBlood = addBlood;
    }
}
