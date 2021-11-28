package com.praktikPBO2SulitOOP;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                Scanner Inputan = new Scanner(System.in);
                Keliling klg = new Keliling();
                Luas Las = new Luas();
                int pilihanMenu;
                while(true){
                    System.out.println("\n\nMenu\n1. Keliling\n2. Luas\n3. Keluar\nInput Pilihan: ");
                    pilihanMenu = Inputan.nextInt();
                    switch (pilihanMenu) {
                        case 1 -> klg.keliling();
                        case 2 -> Las.luas();
                        case 3 -> {
                            //System.out.println("Exit");
                            System.exit(0);
                        }
                        default -> throw new Exception("Pilihan Tidak ada");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}