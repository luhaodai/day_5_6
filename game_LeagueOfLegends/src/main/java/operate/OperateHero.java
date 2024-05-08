package operate;

import pojo.Hero;

public class OperateHero {
    public Hero[] heroes=new Hero[10];
    private void init(){
        heroes[0]=new Hero("哪吒",200,200,2000,0);
        heroes[1]=new Hero("赵云",300,300,3000,0);
        heroes[2]=new Hero("云樱",400,400,4000,0);
        heroes[3]=new Hero("夏侯惇",500,500,5000,0);
        heroes[4]=new Hero("曹操",600,300,6000,0);
        heroes[5]=new Hero("司马懿",700,300,8000,0);
        heroes[6]=new Hero("孙悟空",800,300,9000,0);
        heroes[7]=new Hero("奕星",900,900,9000,0);
        heroes[8]=new Hero("司空震",900,900,9000,0);
        heroes[9]=new Hero("小乔",900,900,9000,0);

    }

    public OperateHero() {
        init();

    }
    public Hero[] getHeroes(){
        return heroes;
    }
}
