package com.PBOEZ;

public class PersegiPanjang implements SegiEmpat{
    public int panjang;
    public int lebar;

    @Override
    public double luas(int a, int b) {
        panjang=a;
        lebar=b;
        return (panjang*lebar);
    }

    @Override
    public double keliling(int c, int d) {
        panjang=c;
        lebar=d;
        return (panjang+panjang+lebar+lebar);
    }
}
