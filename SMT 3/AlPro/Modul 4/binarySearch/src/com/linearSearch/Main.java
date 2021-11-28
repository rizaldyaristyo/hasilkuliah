package com.linearSearch;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] stringDD={{"a","c","d","b","v"}, {"h","g","e","f","u"}, {"k","l","i","j","w"}, {"p","n","o","m","y"}, {"s","r","t","q","x"}};
        String[] koordAwal=new String[stringDD.length*stringDD.length];
        String[] strD=new String[stringDD.length*stringDD.length];
        int incPos=0;
        for (int a=0;a<stringDD.length;a++)
            for (int b=0;b< stringDD.length;b++){
                koordAwal[incPos]=(a+","+b);
                strD[incPos]=stringDD[a][b];
                incPos++;
            }System.out.println();
        for (String[] strings : stringDD) {System.out.println();
            for (int j = 0; j < stringDD.length; j++) System.out.print(strings[j] + " ");
        }
        Scanner inputan = new Scanner(System.in);
        System.out.print("\nSearch: ");
        String input=inputan.nextLine();
        int start=0;
        while(true){
            if (strD[start].equals(input)) {
                System.out.println(strD[start]+" berada di "+koordAwal[start]);
                return;
            }else if (start==(strD.length* strD.length)){
                System.out.println("gaada broh");
                return;
            } start++;
        }
    }
}