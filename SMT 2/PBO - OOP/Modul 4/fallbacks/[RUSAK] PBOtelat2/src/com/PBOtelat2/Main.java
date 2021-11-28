package com.PBOtelat2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        System.out.println("1.) Assassin vs Tank\n2.) Tank vs Warrior\n3.) Warrior vs Assassin");
        System.out.print("choose the competition: ");
        int choice = Inputan.nextInt();
        int level1 = Inputan.nextInt();
        int level2 = Inputan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("==== PLAYER 1 ====");
                System.out.print("level: ");
                Assassin p1 = new Assassin(level1);
                p1.checkStatus();
                Tank p2 = new Tank(level2);
                p2.checkStatus();

                System.out.println("############ ROUND START ############");
                int i = 1;
                while (p1.lifeStatus && p2.lifeStatus){

                    System.out.println("\n\n=== TURN "+i+" ===");
                    System.out.println("- Player 1 Move -");
                    p1.spawnIntro();
                    p1.attack(p2);
                    System.out.println("- Player 2 Move -");
                    p2.spawnIntro();
                    p2.attack(p1);
                    i++;
                }
                break;
            case 2:
                System.out.println("==== PLAYER 1 ====");
                System.out.print("level: ");
                Tank p1 = new Tank(level1);
                p1.checkStatus();
                System.out.println("==== PLAYER 2 ====");
                System.out.print("level: ");
                Warrior p2 = new Warrior(level2);
                p2.checkStatus();

                System.out.println("############ ROUND START ############");
                int i = 1;
                while (p1.lifeStatus && p2.lifeStatus){

                    System.out.println("\n\n=== TURN "+i+" ===");
                    System.out.println("- Player 1 Move -");
                    p1.spawnIntro();
                    p1.attack(p2);
                    System.out.println("- Player 2 Move -");
                    p2.spawnIntro();
                    p2.attack(p1);
                    i++;
                }
                break;
            case 3:
                System.out.println("==== PLAYER 1 ====");
                System.out.print("level: ");
                Warrior p1 = new Warrior(level1);
                p1.checkStatus();
                System.out.println("==== PLAYER 2 ====");
                System.out.print("level: ");
                Assassin p2 = new Assassin(level2);
                p2.checkStatus();

                System.out.println("############ ROUND START ############");
                int i = 1;
                while (p1.lifeStatus && p2.lifeStatus){

                    System.out.println("\n\n=== TURN "+i+" ===");
                    System.out.println("- Player 1 Move -");
                    p1.spawnIntro();
                    p1.attack(p2);
                    System.out.println("- Player 2 Move -");
                    p2.spawnIntro();
                    p2.attack(p1);
                    i++;
                }
                break;
            default:
                System.out.println("no contest");
                System.exit(1);
        }





    }
}
