package com.progLanMod3;
class balok{
    private int panjang;
    private int lebar;
    private int tinggi;

    // Set Variabel
    public void setPanjang(int panjang){
        this.panjang = panjang;
    }

    public void setLebar(int lebar){
        this.lebar = lebar;
    }

    public void setTinggi(int tinggi){
        this.tinggi = tinggi;
    }

    // Get Variabel
    int getPanjang(){
        return panjang;
    }

    int getLebar(){
        return lebar;
    }

    int getTinggi(){
        return tinggi;
    }

    // hasil
    protected void hasil(){
        perhitungan ph = new perhitungan();
        System.out.println("hasil Luas balok : " + ph.luas(this));
        System.out.println("hasil Volume balok : " + ph.volume(this));
    }
}

class perhitungan{
    int luas;
    int volume;

    int luas(balok sisi){
        int panjang = sisi.getPanjang();
        int lebar = sisi.getLebar();
        int tinggi = sisi.getTinggi();

        return luas = panjang * lebar * tinggi;
    }

    int volume(balok sisi){
        int panjangV = sisi.getPanjang();
        int lebarV = sisi.getLebar();
        int tinggiV = sisi.getTinggi();

        return volume = 4 * panjangV * lebarV * tinggiV;
    }
}

// Driver class
class driverClass_Mod3{
    static boolean isCube(long input){
        long a = Math.round(Math.cbrt(input));
        return Math.pow(a, 3) == input;
    }

    public static void main(String[] args) {
        balok x = new balok();

        x.setPanjang(7);
        x.setLebar(7);
        x.setTinggi(7);

        x.hasil();

        System.out.println("hasil Luas balok : " + isCube(1));
    }
}

