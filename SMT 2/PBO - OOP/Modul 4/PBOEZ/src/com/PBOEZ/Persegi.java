package com.PBOEZ;

public class Persegi implements SegiEmpat{
    public int sisi;

    @Override
    public double luas(int a, int b) {
        sisi=a;
        sisi=b;
        return (sisi*sisi);
    }

    @Override
    public double keliling(int c, int d) {
        sisi = c;
        sisi = d;
        return (sisi + sisi + sisi + sisi);
    }
}
