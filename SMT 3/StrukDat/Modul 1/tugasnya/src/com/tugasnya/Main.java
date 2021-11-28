package com.tugasnya;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.println("Mau menampilkan hasil luas dalam bentuk? :\n1. Hasil to integer\n2. Hasil to double\nmasukkan pilihan 1 / 2");
        int choice = inputan.nextInt();
        System.out.println("Masukkan Nilai Alas dan Tinggi secara berurutan");
        if (choice == 1){
            Segitiga<Integer> luasTipeInt = new Segitiga<>(inputan.nextInt(), inputan.nextInt());
            System.out.println("Luas dalam Integer: "+luasTipeInt.getResultAsInt());
        }else{
            Segitiga<Double> luasTipeDouble = new Segitiga<>(inputan.nextDouble(), inputan.nextDouble());
            System.out.println("Luas dalam Float: "+luasTipeDouble.getResultAsDouble());
        }
    }
}