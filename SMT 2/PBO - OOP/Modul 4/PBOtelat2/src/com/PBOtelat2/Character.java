package com.PBOtelat2;

public abstract class Character {
    public double healthPoint;
    public double attackDamage;
    public double defense;
    public int level;
    public boolean lifeStatus;
    public double realDamage;
    public String playerName;

    public void attack(Character target) {
        if (healthPoint!=0){
            spawnIntro();
            reviewDamage(target.defense);
            target.healthPoint = target.healthPoint - realDamage;
            if (target.healthPoint <= 0) {
                target.healthPoint = 0;
                lifeStatus = false;
            }
            System.out.println(target.playerName + " Remaining HP : " + target.healthPoint);
        }else System.out.println("- mmm... it's seems your HP depleted...\n- you can't attack if you're already dead tho...");
    }
    public void reviewDamage(double defense){
        realDamage = attackDamage - defense;
    }
    public abstract void spawnIntro();
    public void checkStatus(String nm, double hp, double def, double atkdmg,boolean ls,int lv){
        level = lv;
        playerName = nm;
        healthPoint=hp;
        defense=def;
        attackDamage=atkdmg;
        lifeStatus=ls;
    }
}
