// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.APBOJavaNyaRev;

public class Company {
    protected String namaOrang,namaJabatan,mataUang,satuan;
    protected int gajiJabatan,jumlahPejabat,levelJabatan;

    public Company(String aa, int bb){
        namaJabatan = aa;
        levelJabatan = bb;
    }
    public Company(String a){namaOrang = a;}
    public Company(int b){jumlahPejabat = b;}
    public Company(String c, int d, String e){
        mataUang = c;
        gajiJabatan = d;
        satuan = e;
    }

}