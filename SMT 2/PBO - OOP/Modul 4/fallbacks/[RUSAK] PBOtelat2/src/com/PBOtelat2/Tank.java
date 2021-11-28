package com.PBOtelat2;

public class Tank extends Character{

    public Tank(int level){
        System.out.println(level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("saya adalah Tank");
    }

    public double getHP(){
        return healthPoint = (level*150)+healthPoint;
    }

    public double getDEF(){
        return defense = (level*15)+defense;
    }

    public double getATKDMG(){
        return attackDamage = (level*10)+attackDamage;
    }
}
