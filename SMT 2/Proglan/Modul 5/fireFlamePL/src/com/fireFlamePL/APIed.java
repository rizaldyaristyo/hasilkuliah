//(c) Rizaldy Aristyo 2021
package com.fireFlamePL;
import java.util.Arrays;
import java.util.Scanner;
public class APIed {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        int[] data = {-80, -50, 0, 40, 0, -30, 90, 70, 89, 50, -55};
        System.out.print("Unsorted  : ");
        for (int i:data) System.out.print(i+" ");
        System.out.println("\n  Sorting...");
        Arrays.sort(data);
        System.out.print("  Completed!\nSorted    : ");
        for (int i:data) System.out.print(i+" ");
        System.out.print("\n  Input desired index element: ");
        int desire = Inputan.nextInt();
        if (Arrays.binarySearch(data, desire)<0) System.out.println("  Index position not found...\n  invalid data input?");
        else System.out.println("  !!!  Index Position Found  !!!\n  Index position of "+desire+" is: "+Arrays.binarySearch(data, desire));
    }
}
//ocdHandler