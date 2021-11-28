// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.progLanMod3;

class balok{
    private int panjang;
    private int lebar;
    private int tinggi;

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    protected void hasil(){
        Perhitungan ph = new Perhitungan();
        System.out.println("Hasil luas balok : " + ph.luas(this));
        System.out.println("Hasil luas balok : " + ph.volume(this));
    }
}

class Perhitungan{
    int volume, luas;

    public int volume(balok sisi) {return volume = 4 * sisi.getPanjang() * sisi.getLebar() * sisi.getTinggi();}

    public int luas(balok sisi) {return luas = sisi.getPanjang() * sisi.getLebar() * sisi.getTinggi();}
}

class Cube extends balok{
    static boolean isCube(long input){
        boolean b = (Math.round(Math.cbrt(input)) * Math.round(Math.cbrt(input))
                * Math.round(Math.cbrt(input))) == input;
        return b;

    }
    int luas(balok sisi){
        setPanjang(5);
        setLebar(5);
        setTinggi(6);
        return sisi.getPanjang() * sisi.getLebar() * sisi.getTinggi();
    }
    void isCoob(){
        System.out.println("isCube: "+luas(this)+" "+isCube(luas(this)));
    }
}

public class Driver {

    public static void main(String[] args) {
        balok objBlk = new balok();
        Cube objCube = new Cube();
        objBlk.setPanjang(5);
        objBlk.setLebar(5);
        objBlk.setTinggi(5);
        objBlk.hasil();
        objCube.isCoob();

    }
}