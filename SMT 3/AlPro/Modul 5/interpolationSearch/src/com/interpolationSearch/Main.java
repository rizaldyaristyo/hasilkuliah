package com.interpolationSearch;
import java.util.Scanner;

class Search{
    void binary(int[] strD,String[] koordAwal,int input,int awal,int akhir){
        int tengah = (awal+akhir)/2;
        if (input==strD[tengah]){
            System.out.println("\n"+strD[tengah]+" berada di "+koordAwal[tengah]);
            return;
        }
        else if(awal==tengah&&akhir==tengah){
            if (input==strD[tengah+1]){
                System.out.println("\n"+strD[tengah+1]+" berada di "+koordAwal[tengah+1]);
                return;
            }
            else if (input==strD[tengah-1]){
                System.out.println("\n"+strD[tengah-1]+" berada di "+koordAwal[tengah-1]);
                return;
            }
            System.out.println("\nngga nemu broh");
            return; // check
        }           // System.out.print("\nstrdTengah: "+strD[tengah]);
        if (input<strD[tengah]) {
            awal = 0;
            akhir = tengah-1;
        }else if(input>strD[tengah]) awal = tengah+1;
        binary(strD,koordAwal,input,awal,akhir);
    }

    void interpolation(int[] strD, String[] koordAwal, int input, int low, int high){
        int erpolation = low+(high-low)*(input-strD[low])/(strD[high] - strD[low]);
        if (input==strD[erpolation]){
            System.out.println("\n"+strD[erpolation]+" berada di "+koordAwal[erpolation]);
            return;
        }
        else if(low==erpolation&&high==erpolation){
            if (input==strD[erpolation+1]){
                System.out.println("\n"+strD[erpolation+1]+" berada di "+koordAwal[erpolation+1]);
                return;
            }
            else if (input==strD[erpolation-1]){
                System.out.println("\n"+strD[erpolation-1]+" berada di "+koordAwal[erpolation-1]);
                return;
            }
            System.out.println("\nngga nemu broh");
            return; // check
        }           // System.out.print("\nstrdTengah: "+strD[tengah]);
        if (input<strD[erpolation]) {
            low = 0;
            high = erpolation-1;
        }else if(input>strD[erpolation]) low = erpolation+1;
        interpolation(strD,koordAwal,input,low,high);
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] intDD={{43,12},{65,46}};
        String[] koordAwal=new String[intDD.length*intDD.length];
        int[] intD=new int[intDD.length*intDD.length];
        int incPos=0;
        for (int a=0;a<intDD.length;a++)
            for (int b=0;b< intDD.length;b++){
                koordAwal[incPos]= (a+","+b);
                intD[incPos]=intDD[a][b];
                incPos++;// check
            }System.out.println("\nString Sebelum Sorting"); for (int str:intD) System.out.print(str+" ");
        System.out.println("\nKoordinat Sebelum Sorting"); for (String koord:koordAwal) System.out.print(koord+" ");
        int swap; String swapCoord;
        boolean stop=false;
        int arrLen= intD.length;
        while (!stop){
            stop=true;
            for(int i=0; i<arrLen-1; i++){
                if (intD[i]>intD[i+1]){
                    swap=intD[i+1]; //SwapStr
                    intD[i+1]=intD[i];
                    intD[i]=swap;
                    swapCoord=koordAwal[i+1]; //SwapCoordinate
                    koordAwal[i+1]=koordAwal[i];
                    koordAwal[i]=swapCoord;
                    stop=false;
                }
            }// check
        }System.out.println("\n\nString Sebelum Sorting"); for (int str:intD) System.out.print(str+" ");
        System.out.println("\nKoordinat Sebelum Sorting"); for (String koord:koordAwal) System.out.print(koord+" ");
        System.out.println();
        for (int[] strings : intDD) {
            System.out.println();
            for (int j = 0; j < intDD.length; j++) System.out.print(strings[j] + " ");
        }
        Scanner inputan = new Scanner(System.in);
        System.out.print("\nSearch: ");
        int input=inputan.nextInt();
        Search search = new Search();
        System.out.println("\nBinary Search: ");
        search.binary(intD,koordAwal,input,0,intD.length-1);
        System.out.println("\nInterpolation Search: ");
        search.interpolation(intD,koordAwal,input,0,intD.length-1);
    }
}
