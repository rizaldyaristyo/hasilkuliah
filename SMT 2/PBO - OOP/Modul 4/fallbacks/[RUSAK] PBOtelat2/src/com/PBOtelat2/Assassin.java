package com.PBOtelat2;

public class Assassin extends Character implements CriticalDamage{

    public Assassin(int level){
        this.level = level;
        System.out.println(this.level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("saya adalah Assassin");
    }

    @Override
    public void critOutput() {
        double plusDamage = attackDamage * 0.2;
        attackDamage = attackDamage + plusDamage;
    }

    public double getHP(){
        return healthPoint = (level*80)+healthPoint;
    }

    public double getDEF(){
        return defense = (level*10)+defense;
    }

    public double getATKDMG(){
        return attackDamage = (level*25)+attackDamage;
    }

    @Override
    public void checkStatus(String nm) {
        Assassin assassin = new Assassin();
        assassin.name = nm;
        assassin.healthPoint=2500;
        assassin.defense=200;
        assassin.attackDamage=750;
        assassin.lifeStatus=true;
        System.out.println("healthPoint : "+assassin.getHP());
        System.out.println("defense : "+assassin.getDEF());
        System.out.println("attackDamage : "+assassin.getATKDMG());
    }
}

