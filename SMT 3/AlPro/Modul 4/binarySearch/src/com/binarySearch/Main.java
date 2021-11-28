package com.binarySearch;
import java.util.Scanner;

class Search{
    void binary(String[] strD,String[] koordAwal,String input,int awal,int akhir){
        int tengah = (awal+akhir)/2;
        if (input.equals(strD[tengah])){
            System.out.println("\n"+strD[tengah]+" berada di "+koordAwal[tengah]);
            return;
        }
        else if(awal==tengah||akhir==tengah){
            if (input.equals(strD[tengah+1])){
                System.out.println("\n"+strD[tengah+1]+" berada di "+koordAwal[tengah+1]);
                return;
            }
            else if (input.equals(strD[tengah-1])){
                System.out.println("\n"+strD[tengah-1]+" berada di "+koordAwal[tengah-1]);
                return;
            }
            System.out.println("\nngga nemu broh");
            return; // check
        }           // System.out.print("\nstrdTengah: "+strD[tengah]);
        if (input.compareTo(strD[tengah])<0) {
            awal = 0;
            akhir = tengah-1;
        }else if(input.compareTo(strD[tengah])>0) awal = tengah+1;
        binary(strD,koordAwal,input,awal,akhir);
    }
}

public class Main {
    public static void main(String[] args) {
	    String[][] stringDD={{"a","c","d","b","v"}, {"h","g","e","f","u"}, {"k","l","i","j","w"}, {"p","n","o","m","y"}, {"s","r","t","q","x"}};
        String[] koordAwal=new String[stringDD.length*stringDD.length];
        String[] stringD=new String[stringDD.length*stringDD.length];
        int incPos=0;
        for (int a=0;a<stringDD.length;a++)
            for (int b=0;b< stringDD.length;b++){
                koordAwal[incPos]=(a+","+b);
                stringD[incPos]=stringDD[a][b];
                incPos++;// check
            }System.out.println("\nString Sebelum Sorting"); for (String str:stringD) System.out.print(str+" ");
            System.out.println("\nKoordinat Sebelum Sorting"); for (String koord:koordAwal) System.out.print(koord+" ");
        String swap;
        boolean stop=false;
        int arrLen= stringD.length;
        while (!stop){
            stop=true;
            for(int i=0; i<arrLen-1; i++){
                if (stringD[i].compareTo(stringD[i+1])>0){
                    swap=stringD[i+1]; //SwapStr
                    stringD[i+1]=stringD[i];
                    stringD[i]=swap;
                    swap=koordAwal[i+1]; //SwapCoordinate
                    koordAwal[i+1]=koordAwal[i];
                    koordAwal[i]=swap;
                    stop=false;
                }
            }// check
        }System.out.println("\n\nString Sebelum Sorting"); for (String str:stringD) System.out.print(str+" ");
        System.out.println("\nKoordinat Sebelum Sorting"); for (String koord:koordAwal) System.out.print(koord+" ");
        System.out.println();
        for (String[] strings : stringDD) {
            System.out.println();
            for (int j = 0; j < stringDD.length; j++) System.out.print(strings[j] + " ");
        }
        Scanner inputan = new Scanner(System.in);
        System.out.print("\nSearch: ");
        String input=inputan.nextLine();
        Search search = new Search();
        search.binary(stringD,koordAwal,input,0,stringD.length-1);
    }
}