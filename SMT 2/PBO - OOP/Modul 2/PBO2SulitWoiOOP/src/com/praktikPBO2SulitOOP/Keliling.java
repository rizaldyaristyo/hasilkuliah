package com.praktikPBO2SulitOOP;
import java.util.Scanner;

public class Keliling {
    void keliling(){
        Scanner Inputan = new Scanner(System.in);
        int jariJari;
        double hasilKeliling;

        System.out.print("Input Jari-Jari (cm): ");
        jariJari=Inputan.nextInt();

        hasilKeliling = 2 * 3.14 * jariJari;
        System.out.printf("Hasil Keliling Lingkaran: %.2f",hasilKeliling);
        /*//Inputan.nextLine();
        //System.exit(0);*/
    }

}
