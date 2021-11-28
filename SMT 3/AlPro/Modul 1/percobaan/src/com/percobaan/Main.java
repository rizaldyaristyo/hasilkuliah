package com.percobaan;

public class Main {
    public static void main(String[] args) {
        long ms = System.currentTimeMillis();
        int[][] arr = { {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                      };
        System.out.println("Array length per column: "+arr.length+"\n");
        for (int j=arr.length-1; j>=0; j--){
            for (int i = arr.length-1; i>=0; i--)
                System.out.print(arr[j][i]+" ");
            System.out.println();
        }
        long mse = System.currentTimeMillis();
        System.out.println("\nElapsed Time : "+ (mse-ms)+"ms");
    }
}