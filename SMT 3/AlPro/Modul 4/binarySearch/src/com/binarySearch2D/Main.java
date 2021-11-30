package com.binarySearch2D;
import java.util.Scanner;

class Search{
    void binary2(String[][] stringDD,String input,int awal,int akhir,int baris){
        int tengah = (awal+akhir)/2;
        System.out.println();
        if(tengah>stringDD.length-1){
            baris++;awal=0;
            akhir=stringDD.length;
            tengah=(awal+akhir)/2;
        }
        if (input.equals(stringDD[baris][tengah])){
            System.out.println("\n"+stringDD[baris][tengah]+" berada di "+baris+","+tengah);
            return;
        }
        else if(awal==tengah&&akhir==tengah) {
            if (input.equals(stringDD[baris][tengah + 1])) {
                System.out.println("\n" + stringDD[baris][tengah + 1] + " berada di " + baris + "," + (tengah+1));
                return;
            } else if (input.equals(stringDD[baris][tengah - 1])) {
                System.out.println("\n" + stringDD[baris][tengah - 1] + " berada di " + baris + "," + (tengah-1));
                return;
            }
            System.out.println("\nngga nemu broh");
            return; // check
        }// System.out.println("strdTengah: "+stringDD[baris][tengah]);
        if (input.compareTo(stringDD[baris][tengah])<0) {
            awal = 0;
            akhir = tengah-1;
        }else if(input.compareTo(stringDD[baris][tengah])>0) awal = tengah+1;
        binary2(stringDD,input,awal,akhir,baris);
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] stringDD={{"a","c","d","b","v"}, {"h","g","e","f","u"}, {"k","l","i","j","w"}, {"p","n","o","m","y"}, {"s","r","t","q","x"}};
        for (String[] strings : stringDD) {
            System.out.println();
            for (int j = 0; j < stringDD.length; j++) System.out.print(strings[j] + " ");
        }
        int j2=0,i2=0;
        for (int a=0; a<stringDD.length*stringDD.length;a++){
            if (j2==stringDD.length){
                j2=0; i2++;
            }
            for (int i=0;i<stringDD.length;i++){
                for (int j=0;j< stringDD.length;j++){
                    if(stringDD[i2][j2].compareTo(stringDD[i][j])<0){
                        String temp=stringDD[i][j];
                        stringDD[i][j]=stringDD[i2][j2];
                        stringDD[i2][j2]=temp;
                    }
                }
            }j2++;
        }System.out.println();
        for (String[] strings : stringDD) {
            System.out.println();
            for (int j = 0; j < stringDD.length; j++) System.out.print(strings[j] + " ");
        }
        Scanner inputan = new Scanner(System.in);
        System.out.print("\nSearch: ");
        String input=inputan.nextLine();
        Search search = new Search();
        search.binary2(stringDD,input,0, stringDD.length, 0);
    }
}