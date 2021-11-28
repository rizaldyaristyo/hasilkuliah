package com.tugas1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        System.out.print("\nOrdo : ");
        int ordo = Inputan.nextInt();
        int[][] arr = new int[ordo][ordo];
        System.out.println("Enter Matrices");
        for (int a = 0; a < ordo; a++) for (int b = 0; b < ordo; b++) arr[a][b] = Inputan.nextInt();
        System.out.println("\narr.len=" + arr.length + "\n");
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) System.out.print(arr[j][i] + " ");
            System.out.println();
        }System.out.println("\nBig O = (x*n²)(y*n²)\n\t\t(1*"+(ordo)+"²)"+"(1*"+(ordo)+"²)");
    }
}