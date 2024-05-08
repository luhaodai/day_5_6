package operate;

import pojo.WildMonster;

public class OperateWildMonster {
    WildMonster[] wildMonsters=new WildMonster[100];

    public void init() {
        int index_wildMonsters = 0;
        for (int j = 0; j < 20; j++) {
            wildMonsters[index_wildMonsters++] = new WildMonster("野猪"+j, 200, 200, 1000, 500);
        }
        for (int j = 0; j < 20; j++) {
            wildMonsters[index_wildMonsters++] = new WildMonster("莲花怪"+j, 300, 300, 500, 600);
        }
        for (int j = 0; j < 20; j++) {
            wildMonsters[index_wildMonsters++] = new WildMonster("火妖"+j, 500, 300, 3000, 700);
        }
        for (int j = 0; j < 20; j++) {
            wildMonsters[index_wildMonsters++] = new WildMonster("水妖"+j, 900, 900, 4000, 800);
        }
        for (int j = 0; j < 20; j++) {
            wildMonsters[index_wildMonsters++] = new WildMonster("山妖"+j, 900, 900, 5000, 900);
        }

    }
    public OperateWildMonster() {
        init();
    }

    public WildMonster[] getWildMonsters() {
        return wildMonsters;
    }
}
