//(c) Rizaldy Aristyo 2021
package com.fireFlamePL;
import java.util.Scanner;
public class NonAPI {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
	    int[] data = {-80, -50, 0, 40, 0, -30, 90, 70, 89, 50, -55};
        int swap;
        boolean berhenti = false;
        System.out.print("Unsorted  : ");
        for (int i:data) System.out.print(i+" ");
        System.out.println("\n  Sorting...");
        while(!berhenti){
            berhenti = true;
            for (int i = 0; 9 >= i; i++) {
                if (data[i] > data[i + 1]) {
                    swap = data[i + 1];
                    data[i + 1] = data[i];
                    data[i] = swap;
                    berhenti = false;
                }
            }
        }
        System.out.println("  Completed!");
        System.out.print("Sorted    : ");
        for (int i:data) System.out.print(i+" ");
        System.out.print("\n  Input desired index element: ");
        int desire = Inputan.nextInt();
        int j=0;
        for (int i:data) {
            if (i==desire){
                System.out.println("  !!!  Index Position Found  !!!");
                System.out.println("  Index position of "+i+" is: "+(j));
                /*for(int k=j+1;data[k]=='\0';k++){
                    if (data[k]==desire){
                        System.out.println("  can be found on Index position : "+(k)+" too");
                        System.exit(0);
                    }
                }*/
                System.exit(0);
            }
            j++;
        }System.out.println("  Index position not found...\n  invalid data input?");
    }
}//ocdHandled