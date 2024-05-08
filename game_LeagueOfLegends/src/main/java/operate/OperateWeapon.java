package operate;

import pojo.Hero;
import pojo.Weapon;

public class OperateWeapon {
    public Weapon[] weapons=new Weapon[10];
    public boolean is_beUsed=false;

    private void init(){
        weapons[0]=new Weapon("魔女斗篷",0,2000,2000,2000);
        weapons[1]=new Weapon("破军",2000,0,2900,0);
        weapons[2]=new Weapon("宗师之力",1000,300,1900,300);
        weapons[3]=new Weapon("闪电之力",300,0,1800,200);
        weapons[4]=new Weapon("红莲斗篷",100,1000,2100,1800);
        weapons[5]=new Weapon("复活甲",0,1000,2300,800);
        weapons[6]=new Weapon("辉月",0,99999999,2000,1700);
        weapons[7]=new Weapon("尚方宝剑",900,900,2000,1000);
        weapons[8]=new Weapon("倚天剑",1000,700,2100,1100);
        weapons[9]=new Weapon("屠龙宝刀",3000,0,3000,0);
        Weapon.weaponMaxIndex=weapons.length;
        Weapon.weaponMinimumIndex=0;

    }

    public OperateWeapon() {
        init();
    }

    public Weapon[] getWeapons() {
        return weapons;
    }
}
