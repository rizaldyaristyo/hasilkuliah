package com.PBOtelat2;

public class Warrior extends Character{

    public Warrior(int level){
        System.out.println(level);
    }
    @Override
    public void spawnIntro(){
        System.out.println("saya adalah Warrior");
    }
}
