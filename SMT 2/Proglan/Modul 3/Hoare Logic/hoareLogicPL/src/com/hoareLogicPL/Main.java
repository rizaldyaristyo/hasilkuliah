package com.hoareLogicPL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Scanner Inputan = new Scanner(System.in);
            int x, y, z;
            System.out.print("masukkan integer positif x    : ");
            x = Inputan.nextInt();
            if (x <= 0) {
                throw new Exception();
            }
            System.out.print("masukkan integer positif z    : ");
            z = Inputan.nextInt();
            if (z <= 0){
                throw new Exception();
            }
            y = x * z;
            System.out.print("kembalian nilai y adalah      : " + y);
            System.exit(y);
        }catch(Exception e){
            System.out.println("inputan bukan int positif, mengembalikan nilai 0");
            System.exit(0);
        }
    }
}
