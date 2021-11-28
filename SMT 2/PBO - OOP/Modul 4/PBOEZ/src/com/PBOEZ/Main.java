package com.PBOEZ;

public class Main {

    public static void main(String[] args) {
        SegiEmpat p = new Persegi();
        SegiEmpat pp = new PersegiPanjang();
        Kubus k = new Kubus();
        Balok b = new Balok();

        System.out.println("Luas Segi Empat          : "+p.luas(2,2));
        System.out.println("Luas Persegi Panjang     : "+pp.luas(3,4));
        System.out.println("Keliling Segi Empat      : "+p.keliling(2,2));
        System.out.println("Keliling Persegi Panjang : "+pp.keliling(3,4));
        System.out.println("Volume Kubus             : "+k.getVolume(2,2,2));
        System.out.println("Volume Balok             : "+b.getVolume(3,4,5));
    }
}
