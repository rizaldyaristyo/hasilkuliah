package com.PBOtelat;

public class Balok extends BangunRuang{

    @Override
    void getLuasPermukaan(double p, int l, int t){
        System.out.println("Luas Permukaan Balok  : "+(2*((p*l)+(p*t)+(l*t))));
    }

    @Override
    void getVolume(double p, int l, int t){
        System.out.println("Volume Tabung : "+(p*l*t));
    }
}
