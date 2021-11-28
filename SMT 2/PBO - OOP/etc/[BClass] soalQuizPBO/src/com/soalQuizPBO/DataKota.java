package com.soalQuizPBO;

public class DataKota {
    double Total, Limbah, Air, Udara;
    String namaKota;
    public void strnamaKota(String namaKota){
        this.namaKota = namaKota;
    }
    public void doubleLimbah(double Limbah){
        this.Limbah = Limbah;
    }
    public void doubleAir(double Air){
        this.Air = Air;
    }
    public void doubleUdara(double Udara){
        this.Udara = Udara;
    }
    public void doubleTotal(){
        this.Total = (this.Limbah * 0.4) + (this.Air * 0.3) + (this.Udara * 0.3);
    }

}
