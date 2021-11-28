package com.Tac;
import com.APBOJavaNya.Konst;
public class Child extends Konst{
    public void jabatan3(int a) { System.out.println("Jumlah Editor: " + a); }

    public void jabatan3(int a, int b) { System.out.println("Jumlah Gaji Semua Manager Editor: " + a * (b+super.bonusPangkat)); }

    public void jabatan4(int a) { System.out.println("Jumlah Desainer: " + a); }

    public void jabatan4(int a, int b) { System.out.println("Jumlah Gaji Semua Manager Desainer: " + a * (b+super.bonusPangkat)); }

}
