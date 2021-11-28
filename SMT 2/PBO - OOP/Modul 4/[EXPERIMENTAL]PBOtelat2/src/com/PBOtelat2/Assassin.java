package com.PBOtelat2;

public class Assassin extends Character implements CriticalDamage{

    public Assassin(int level,String playerN){
        this.level = level;
        checkStatus(playerN,2500,200,750,true,this.level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("'I'm speed, moving like a.. uhh... forgot my line...'");
    }

    public double getHP(){
        return healthPoint = (level*80)+healthPoint;
    }

    public double getDEF(){
        return defense = (level*10)+defense;
    }

    public double getATKDMG(){
        double getatkd = (level*25)+attackDamage;
        return attackDamage=critOutput(getatkd);
    }
    @Override
    public double critOutput(double getatkd) {
        double plusDamage = attackDamage * 0.2;
        return getatkd + plusDamage;
    }
}

