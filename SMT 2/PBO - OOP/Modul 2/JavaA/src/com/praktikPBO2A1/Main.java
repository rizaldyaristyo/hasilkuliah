package com.praktikPBO2A1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        System.out.print("Masukkan panjang dalam Mil    : ");
        int panjangMil = Inputan.nextInt();
        Inputan.close();
        float panjangM   = panjangMil*1609;
        float panjangMm  = panjangM*1000;
        float panjangCm  = panjangM*100;
        float panjangDm  = panjangM*10;
        float panjangDam = panjangM/10;
        float panjangHm  = panjangM/100;
        float panjangKm  = panjangM/1000;
        System.out.println("Panjang dalam Milimeter     : " + panjangMm);
        System.out.println("Panjang dalam Centimeter    : " + panjangCm);
        System.out.println("Panjang dalam Desimeter     : " + panjangDm);
        System.out.println("Panjang dalam Meter         : " + panjangM);
        System.out.println("Panjang dalam Dekameter     : " + panjangDam);
        System.out.println("Panjang dalam Hektometer    : " + panjangHm);
        System.out.println("Panjang dalam Kilometer     : " + panjangKm);
    }
}
