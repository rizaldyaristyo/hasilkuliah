package com.praktikPBO2SulitStruct;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner Inputan = new Scanner(System.in);
            int pilihanMenu;

            System.out.println("Menu");
            System.out.println("1. Keliling");
            System.out.println("2. Luas");
            System.out.println("3. Keluar");
            System.out.print("Input Pilihan: ");
            pilihanMenu = Inputan.nextInt();

            if (pilihanMenu==1){

                int jariJari;
                double hasilKeliling;

                System.out.print("Input Jari-Jari: ");
                jariJari=Inputan.nextInt();

                hasilKeliling = 2 * 3.14 * jariJari;
                System.out.println("Hasil Keliling Lingkaran: " + hasilKeliling);
                System.exit(0);

            }else if (pilihanMenu==2){

                int jariJari;
                double hasilLuas;

                System.out.print("Input Jari-Jari: ");
                jariJari=Inputan.nextInt();

                hasilLuas = 3.14 * jariJari * jariJari;
                System.out.println("Hasil Luas Lingkaran: " + hasilLuas);
                System.exit(0);

            }else if (pilihanMenu==3) System.exit(0);
            else throw new Exception("Pilihan Tidak ada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
