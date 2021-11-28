//(c) Rizaldy Aristyo 2021
package com.fireFlamePL;
import java.util.Arrays;
import java.util.Scanner;
public class Ratioed {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        System.out.print("Size : ");
        int size = Inputan.nextInt();
        int[] data = new int[size];
        System.out.print("Input data : ");                        //input this to data:
        for (int i = 0; i < size; i++) data[i]=Inputan.nextInt(); //-80 -50 0 40 0 -30 90 70 89 50 -55
        Arrays.sort(data);
        System.out.println("\nResult :");
        for (int i:data) System.out.print(i+" ");
        float banyakPlus = 0;
        float banyakMin = 0;
        float banyakEnol = 0;
        for (int j : data) {
            if (j > 0) banyakPlus++;
            else if (j < 0) banyakMin++;
            else banyakEnol++;
        }
        System.out.println("\n\nPositif : "+String.format("%.2f",(banyakPlus / size)));
        System.out.println("Negatif : "+String.format("%.2f",(banyakMin / size)));
        System.out.println("Zero    : "+String.format("%.2f\n",(banyakEnol / size)));
    }
}