package com.praktikPBO2A2;
import java.util.Scanner;

// UNCOMPLETED GODAMMIT

public class Main {
    int panjangMil;

    public int getPanjangMil() {
        return panjangMil;
    }

    public void setPanjangMil(int panjangMil) {
        this.panjangMil = panjangMil;
    }

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        Main objKu = new Main();
        Meter objMeter = new Meter();
        objKu.setPanjangMil(Inputan.nextInt());
        //objKu.panjangMil = Inputan.nextInt();
        //Inputan.close();
        objMeter.setPanjangMeter(objMeter.panjangMeter);
        System.out.println("panjangMil      = "+objKu.getPanjangMil());
        System.out.println("panjangMeter    = "+objMeter.getPanjangMeter());

    }
}

class Meter{
    int panjangMeter;

    public int getPanjangMeter() {
        return panjangMeter;
    }

    public void setPanjangMeter(int panjangMeter) {
        Main objMu = new Main();
        this.panjangMeter = objMu.panjangMil*1609;
    }
}