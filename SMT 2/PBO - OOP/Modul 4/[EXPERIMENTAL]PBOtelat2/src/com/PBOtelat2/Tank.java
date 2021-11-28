package com.PBOtelat2;

public class Tank extends Character{

    public Tank(int level,String playerN){
        this.level = level;
        checkStatus(playerN,5000,400,400,true,this.level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("'I wish to clarify that i'm a Tank, not Masochist'");
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
