package com.PBOtelat;
public class SopirDosen {
    public static void main(String[] args) {
        final double phi = 3.14;



        Tabung objTab = new Tabung();
        objTab.getLuasPermukaan(phi,2,3);
        objTab.getVolume(phi,2,3);

        Balok objBal = new Balok();
        objBal.getLuasPermukaan(2,3,4);
        objBal.getVolume(2,3,4);
    }
}
