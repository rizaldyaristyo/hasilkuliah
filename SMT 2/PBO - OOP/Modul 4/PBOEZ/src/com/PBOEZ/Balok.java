package com.PBOEZ;

public class Balok extends PersegiPanjang{
    public int tinggi;
    double getVolume(int a,int b,int c){
        panjang=a;
        lebar=b;
        tinggi=c;
        return panjang*lebar*tinggi;
    }
}
