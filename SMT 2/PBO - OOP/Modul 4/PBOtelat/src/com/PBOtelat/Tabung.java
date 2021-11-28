package com.PBOtelat;

public class Tabung extends BangunRuang{

    @Override
    void getLuasPermukaan(double phi, int r, int t){
        System.out.println("Luas Permukaan Tabung : "+String.format("%.2f",(2*phi*r*(r+t))));
    }

    @Override
    void getVolume(double phi, int r, int t){
        System.out.println("Volume Tabung : "+(phi*(r*r)*t));
    }
}
