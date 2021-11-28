package com.PBOtelat2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Provokator {
    public static void main(String[] args) {
        try {
            Scanner Inputan = new Scanner(System.in);
            System.out.print("===Menu Duel===\n 1.) Assassin vs Warrior\n 2.) Warrior  vs Tank\n 3.) Assassin vs Tank\nDecide the Duel!: ");
            int choice = Inputan.nextInt();
            System.out.print("GM privilege ON, Decide both Duelists experience level \n  level P1: ");
            int levelP1 = Inputan.nextInt();
            System.out.print("  level P2: ");
            int levelP2 = Inputan.nextInt();
            //Objects
            Tank tankP2 = new Tank(levelP2, "Player 2");
            Warrior warriorP1 = new Warrior(levelP1, "Player 1");
            Warrior warriorP2 = new Warrior(levelP2, "Player 2");
            Assassin assassinP1 = new Assassin(levelP1, "Player 1");
            //Switches
            int i = 1;
            switch (choice) {
                case 1 -> {                                          //Case1 Assassin vs Warrior
                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + assassinP1.level + "\nhealthPoint : " + assassinP1.getHP() + " defense : "
                            + assassinP1.getDEF() + "\nattackDamage : " + assassinP1.getATKDMG() + " lifeStatus: " + assassinP1.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + warriorP2.level + "\nhealthPoint : " + warriorP2.getHP() + " defense : " + warriorP2.getDEF()
                            + "\nattackDamage : " + warriorP2.getATKDMG() + " lifeStatus: " + warriorP2.lifeStatus + "\n\n############ ROUND START ############");
                    while (assassinP1.lifeStatus && warriorP2.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        assassinP1.attack(warriorP2);
                        System.out.println("- Player 2 TURN -");
                        warriorP2.attack(assassinP1);
                        i++;
                    }
                    if (assassinP1.lifeStatus) System.out.println("\nPlayer 2 Win!");
                    else System.out.println("\nPlayer 1 Win!");
                }
                case 2 -> {                                          //Case2 Warrior vs Tank
                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + warriorP1.level + "\nhealthPoint : " + warriorP1.getHP()
                            + " defense : " + warriorP1.getDEF() + "\nattackDamage : " + warriorP1.getATKDMG() + " lifeStatus: " + warriorP1.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + tankP2.level + "\nhealthPoint : " + tankP2.getHP() + " defense : " + tankP2.getDEF()
                            + "\nattackDamage : " + tankP2.getATKDMG() + " lifeStatus: " + tankP2.lifeStatus + "\n\n############ ROUND START ############");
                    while (warriorP1.lifeStatus && tankP2.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        warriorP1.attack(tankP2);
                        System.out.println("- Player 2 TURN -");
                        tankP2.attack(warriorP1);
                        i++;
                    }
                    if (warriorP1.lifeStatus) System.out.println("\nPlayer 2 Win!");
                    else System.out.println("\nPlayer 1 Win!");
                }
                case 3 -> {                                          //Case3 Assassin vs Tank
                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + assassinP1.level + "\nhealthPoint : " + assassinP1.getHP() + " defense : "
                            + assassinP1.getDEF() + "\nattackDamage : " + assassinP1.getATKDMG() + " lifeStatus: " + assassinP1.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + tankP2.level + "\nhealthPoint : " + tankP2.getHP() + " defense : " + tankP2.getDEF()
                            + "\nattackDamage : " + tankP2.getATKDMG() + " lifeStatus: " + tankP2.lifeStatus + "\n\n############ ROUND START ############");
                    while (assassinP1.lifeStatus && tankP2.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        assassinP1.attack(tankP2);
                        System.out.println("- Player 2 TURN -");
                        tankP2.attack(assassinP1);
                        i++;
                    }
                    if (assassinP1.lifeStatus) System.out.println("\nPlayer 2 Win!");
                    else System.out.println("\nPlayer 1 Win!");
                }default -> throw new Exception("Defaulted");
            }
        } catch (InputMismatchException e) {
            System.out.println("dude... the input was simple, they only accept integers here..\nwhat made you so ignorant?");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Something went wrong... What have you done..?");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
//ocdHandler