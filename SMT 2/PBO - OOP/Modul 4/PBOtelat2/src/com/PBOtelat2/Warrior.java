package com.PBOtelat2;

public class Warrior extends Character{

    public Warrior(int level,String playerN){
        this.level = level;
        checkStatus(playerN,3000,250,800,true,this.level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("'I know you're in panic!! because I do too...'");
    }

    public double getHP(){
        return healthPoint = (level*100)+healthPoint;
    }

    public double getDEF(){
        return defense = (level*10)+defense;
    }

    public double getATKDMG(){
        return attackDamage = (level*15)+attackDamage;
    }
}
