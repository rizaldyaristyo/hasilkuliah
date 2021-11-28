package com.PBOtelat2;

public abstract class Character {
    public double healthPoint;
    public double attackDamage;
    public double defense;
    public int level;
    public boolean lifeStatus;
    public double realDamage;
    public String name;

    public void attack(Character target) {
        reviewDamage(target.defense);
        target.healthPoint = target.healthPoint - realDamage;
        if (target.healthPoint<=0){
            target.healthPoint = 0;
            System.out.println("lifestatus = false");
            lifeStatus = false;
        }
        System.out.println(target.name+" Remaining HP : "+ target.healthPoint);
    }
    public void reviewDamage(double defense){
        realDamage = attackDamage - defense;
    }
    public abstract void spawnIntro();
    public void checkStatus(String nm) {

    }
}
