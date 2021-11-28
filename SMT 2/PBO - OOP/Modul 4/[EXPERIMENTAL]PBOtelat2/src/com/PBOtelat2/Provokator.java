package com.PBOtelat2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Provokator {
    public static void main(String[] args) {
        try {
            Scanner Inputan = new Scanner(System.in);
            System.out.println("""
                    ===Menu Duel===
                     1.) Assassin vs Warrior
                     2.) Warrior vs Tank
                     3.) Assassin vs Tank
                    ===Inverse Menu===
                     4.) Warrior vs Assassin
                     5.) Tank vs Warrior
                     6.) Tank vs Assassin
                    Decide the Duel!:\s""");
            int swap, choice = Inputan.nextInt();
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
                    if (assassinP1.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
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
                    if (warriorP1.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
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
                    if (assassinP1.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
                }case 4 -> {                                          //Case4 Warrior vs Assassin

                    warriorP2.playerName = "Player 1";
                    assassinP1.playerName = "Player 2";

                    swap = warriorP2.level;
                    warriorP2.level = assassinP1.level;
                    assassinP1.level = swap;

                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + warriorP2.level + "\nhealthPoint : " + warriorP2.getHP() + " defense : "
                            + warriorP2.getDEF() + "\nattackDamage : " + warriorP2.getATKDMG() + " lifeStatus: " + warriorP2.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + assassinP1.level + "\nhealthPoint : " + assassinP1.getHP() + " defense : " + assassinP1.getDEF()
                            + "\nattackDamage : " + assassinP1.getATKDMG() + " lifeStatus: " + assassinP1.lifeStatus + "\n\n############ ROUND START ############");
                    while (warriorP2.lifeStatus && assassinP1.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        warriorP2.attack(assassinP1);
                        System.out.println("- Player 2 TURN -");
                        assassinP1.attack(warriorP2);
                        i++;
                    }
                    if (warriorP2.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
                }
                case 5 -> {                                          //Case5 Tank vs Warrior
                    tankP2.playerName = "Player 1";
                    warriorP1.playerName = "Player 2";
                    swap = tankP2.level;
                    tankP2.level = warriorP1.level;
                    warriorP1.level = swap;
                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + tankP2.level + "\nhealthPoint : " + tankP2.getHP()
                            + " defense : " + tankP2.getDEF() + "\nattackDamage : " + tankP2.getATKDMG() + " lifeStatus: " + tankP2.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + warriorP1.level + "\nhealthPoint : " + warriorP1.getHP() + " defense : " + warriorP1.getDEF()
                            + "\nattackDamage : " + warriorP1.getATKDMG() + " lifeStatus: " + warriorP1.lifeStatus + "\n\n############ ROUND START ############");
                    while (tankP2.lifeStatus && warriorP1.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        tankP2.attack(warriorP1);
                        System.out.println("- Player 2 TURN -");
                        warriorP1.attack(tankP2);
                        i++;
                    }
                    if (tankP2.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
                }
                case 6 -> {                                          //Case6 Tank vs Assassin
                    tankP2.playerName = "Player 1";
                    assassinP1.playerName = "Player 2";
                    swap = tankP2.level;
                    tankP2.level = assassinP1.level;
                    assassinP1.level = swap;
                    System.out.println("\n==== PLAYER 1 ====\n" + "level: " + tankP2.level + "\nhealthPoint : " + tankP2.getHP() + " defense : "
                            + tankP2.getDEF() + "\nattackDamage : " + tankP2.getATKDMG() + " lifeStatus: " + tankP2.lifeStatus
                            + "\n\n==== PLAYER 2 ====\n" + "level: " + assassinP1.level + "\nhealthPoint : " + assassinP1.getHP() + " defense : " + assassinP1.getDEF()
                            + "\nattackDamage : " + assassinP1.getATKDMG() + " lifeStatus: " + assassinP1.lifeStatus + "\n\n############ ROUND START ############");
                    while (tankP2.lifeStatus && assassinP1.lifeStatus) {
                        System.out.println("\n=== TURN " + i + " ===\n- Player 1 TURN -");
                        tankP2.attack(assassinP1);
                        System.out.println("- Player 2 TURN -");
                        assassinP1.attack(tankP2);
                        i++;
                    }
                    if (tankP2.lifeStatus) System.out.println("- I see their HP depleted to zero... -\n- so.... -\n\n- Player 2 Win! -");
                    else System.out.println("\n- Player 1 Win! -");
                }default -> System.out.println("\n==== PLAYER 1 ====\n- ummm... -\n- ...dude you haven't chosen any duel yet -");
            }
        } catch (InputMismatchException e) {
            System.out.println("dude... the input was simple, they only accept integers here..\nwhat made you so ignorant?");
            System.exit(1);
        }
    }
}//ocd