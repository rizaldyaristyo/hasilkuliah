package com.praktikPBO2SulitOOP;
import java.util.Scanner;

public class Luas {
    void luas(){
        Scanner Inputan = new Scanner(System.in);
        int jariJari;
        double hasilLuas;

        System.out.print("Input Jari-Jari (cm): ");
        jariJari=Inputan.nextInt();

        hasilLuas = 3.14 * jariJari * jariJari;
        System.out.printf("Hasil Luas Lingkaran: %.2f",hasilLuas);
        /*//Inputan.nextLine();
        //System.exit(0);*/
    }

}
