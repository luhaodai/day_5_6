package game;

import operate.OperateHero;
import operate.OperateProduct;
import operate.OperateWeapon;
import operate.OperateWildMonster;
import pojo.Hero;
import pojo.Product;
import pojo.Weapon;
import pojo.WildMonster;

import java.util.Random;
import java.util.Scanner;

public class Game {
public Hero[] heroes;
public Product[] products;
public Weapon[] weapons;
public WildMonster[] wildMonsters;


    public void init(){
        OperateHero operateHero = new OperateHero();
        OperateWeapon operateWeapon = new OperateWeapon();
        OperateProduct operateProduct = new OperateProduct();
        OperateWildMonster operateWildMonster = new OperateWildMonster();
        heroes=operateHero.getHeroes();
        products=operateProduct.getProducts();
        weapons=operateWeapon.getWeapons();
        wildMonsters=operateWildMonster.getWildMonsters();
    }
    public Game(){
        init();

    }
    public void  gameStart() throws InterruptedException {
        System.out.println("**********欢迎来到英雄联盟***********");
        System.out.println();
        init();
//        展示英雄信息
        showHeros();
//        选择英雄
        Hero player = choiceHero();
        double bloodCopyPlayer=player.blood;
        Hero AI=choiceHeroForAI();
        double bloodCCopyAI=AI.blood;

//        展示双方选择的英雄
        showHeroEachOther(player,AI);
//        开始打怪
        attackWildMonster(player,AI);
//        双方都无法继续与野怪战斗
        showHeroEachOther(player,AI);
//        回复双方血量
        RestoreBlood(bloodCopyPlayer,bloodCCopyAI,AI,player);
//        挑选装备
        choiceWeapons(player,AI);
//        双方最后一战

        





        System.out.println();
        System.out.println("************************************");
        System.out.println("祝您身心愉悦，期待您下一次游戏！");
    }

    private void choiceWeapons(Hero player, Hero ai) {
        int i=1,choice;
        do {
            for (Weapon weapon : weapons) {
                System.out.println(i++ + "\t" + weapon);

            }
            System.out.print("请选择您想要购买的装备:");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice<Weapon.weaponMaxIndex&&choice>=Weapon.weaponMinimumIndex)
            player.weapons[player.weaponsIndex++] = weapons[choice-1];
            System.out.printf("%s第%d个装备为%s\n",player.name,player.weaponsIndex,player.weapons[player.weaponsIndex-1].name);
        }while(choice==-1);






    }

    private void RestoreBlood(double bloodCopyPlayer, double bloodCCopyAI, Hero ai, Hero player) {
        ai.blood=bloodCCopyAI;
        player.blood=bloodCopyPlayer;
    }

    private void attackWildMonster(Hero player, Hero ai) throws InterruptedException {
        Hero[] pPerv=new Hero[2];
        pPerv[0]=player;
        pPerv[1]=ai;
        Hero nextHero;
        int stackPeopleIndex;
        for (WildMonster wildMonster : wildMonsters) {

            do {
                stackPeopleIndex=(int)(Math.random()*pPerv.length);
                    nextHero = pPerv[stackPeopleIndex];
            }while(!nextHero.is_alive);

            stackOk(nextHero,wildMonster);

            if(!wildMonster.is_alive){
                //野怪死亡
                    nextHero.money+=wildMonster.money;
                    System.out.printf("恭喜%s打败%s野怪获得%d金币，现有%d金币\n",nextHero.name,wildMonster.name,wildMonster.money,nextHero.money);
//                    Thread.sleep(5000);
            } else{
                //玩家退出狩猎场，野怪还未死亡
                if(stackPeopleIndex==0){
                    nextHero=pPerv[1];
                    stackOk(nextHero,wildMonster);


                }else{
                    nextHero=pPerv[0];
                    stackOk(nextHero,wildMonster);

                }
            }
            if(!player.is_alive&&!ai.is_alive){
                return;
            }


        }

    }
    public   void stackOk(Hero pPrev,WildMonster wildMonster) throws InterruptedException {
        int productsindex=0;
//        随机攻击
        int  pPrevIndex = new Random().nextInt(2);


//            武器的攻击力       英雄
        int weaponsStack=0;
        for (Weapon weapon : pPrev.weapons) {
            if(weapon!=null) {
                weaponsStack += weapon.attack;
            }
        }

//            英雄打怪自带暴击伤害
        pPrev.criticalStrike=new Random().nextInt(10,20);
//            总攻击力   英雄
        double hitToWildMonster=pPrev.attack+weaponsStack+pPrev.criticalStrike;
        hitToWildMonster*=0.8;

//            野怪的攻击力
        double hitToHero=wildMonster.attack*0.5;


        while(pPrev.blood>0&&wildMonster.blood>0){

    if (pPrevIndex == 1) {
        pPrevIndex=0;
        //由玩家优先发起进攻
        if (wildMonster.blood > hitToWildMonster) {
            wildMonster.blood -= hitToWildMonster;
            System.out.printf("%s对%s造成了%f的攻击力，%s剩余血量为%f\n", pPrev.name, wildMonster.name, hitToWildMonster, wildMonster.name, wildMonster.blood);
//            Thread.sleep(5000);

        } else {

            System.out.printf("%s对%s造成了%f的攻击力，%s死亡\n", pPrev.name, wildMonster.name, wildMonster.blood, wildMonster.name);
            wildMonster.blood = 0;
            wildMonster.is_alive = false;
//            Thread.sleep(5000);
            return;


        }

    } else {
        pPrevIndex=1;
        //由野怪先发起的进攻
            if (pPrev.blood <= hitToHero) {
                System.out.printf("%s对%s发出攻击，造成了%f的伤害,%s濒临死亡\n", wildMonster.name, pPrev.name, hitToHero, pPrev.name);
//                Thread.sleep(5000);
//                玩家有钱购买血瓶，且还存在血瓶
                while (true) {
                    productsindex=0;
                    for (Product product : products) {
                        productsindex++;

                        if (!product.is_used) {
                            break;
                        }

                    }
//                        TODO
                    if(productsindex==products.length||productsindex==products.length){
                        System.out.printf("%s血量不足，已退出狩猎场", pPrev.name);
//                        Thread.sleep(5000);
                        pPrev.is_alive = false;
                        return;
                    }
//                    if ( products[products.length - 1].is_used) {
////                            退出前的提示
//                        System.out.println("%s血量不足，已退出狩猎场");
//                        pPrev.is_alive = false;
//                        return;
//                    }
//                            买血瓶
                        products[productsindex-1].is_used = true;
                        pPrev.money -= products[productsindex-1].money;
                        pPrev.blood += products[productsindex-1].addBlood;
                    System.out.printf("%s购买%s获得%d的血量，现有血量%f",pPrev.name,products[productsindex-1].name,products[productsindex-1].addBlood,pPrev.blood);
//                    Thread.sleep(5000);
                    if(pPrev.blood>hitToHero){
                        System.out.println("玩家购买且使用血瓶，与野怪继续战斗");
                        break;
                    }


                    //退出循环的条件是pPrev.blood>=hitToHero ||products[products.length-1].is_used

                }


            } else {
                pPrev.blood -= hitToHero;
                System.out.printf("%s对%s发出攻击，造成了%f的伤害,%s剩余血量为%f\n", wildMonster.name, pPrev.name, hitToHero, pPrev.name, pPrev.blood);
            }

        }

        }

    }

    private void showHeroEachOther(Hero player, Hero ai) {
        System.out.println();
        System.out.println("您选择的英雄是：");
        System.out.println("姓名\t攻击力\t防御力\t血量\t金钱\t武器\t背包\n");
            System.out.printf("%s\t%d\t\t%d\t\t%f\t%d\t\tnull\tnull\n",
                    player.name,player.attack,player.defense,player.blood,player.money);
        System.out.println();
        System.out.println("敌方英雄:");
        System.out.println("姓名\t攻击力\t防御力\t血量\t金钱\t武器\t背包\n");
        System.out.printf("%s\t%d\t\t%d\t\t%f\t%d\t\tnull\tnull\n",
                ai.name,ai.attack,ai.defense,ai.blood,ai.money);
        System.out.println();
    }

    private Hero choiceHeroForAI() {
        Random random = new Random();
        do {
            int i = random.nextInt(heroes.length);
            if (heroes[i ].is_used == false) {
                return heroes[i];
            } else {
                continue;
            }
        }while (true);


    }

    private Hero choiceHero() {
        do {
            System.out.println("请选择您的英雄：");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
//        清除影响
            scanner.nextLine();

            if (choice <= 0 || choice > heroes.length) {
                System.out.println("请照序号选择，请选择有效序号！");
            } else {
                heroes[choice-1].is_used=true;
                return heroes[choice - 1];
            }
        }while (true);



    }

    private void showHeros() {
        int i=1;
        System.out.println("序号\t姓名\t攻击力\t防御力\t血量\t金钱\t武器\t背包\n");
        for (Hero hero : heroes) {
            System.out.printf("%d\t\t%s\t%d\t\t%d\t\t%f\t%d\t\tnull\tnull\n",
                    i++,hero.name,hero.attack,hero.defense,hero.blood,hero.money);
        }

    }


}
