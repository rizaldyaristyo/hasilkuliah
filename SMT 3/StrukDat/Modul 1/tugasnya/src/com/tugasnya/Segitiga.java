package com.tugasnya;
public class Segitiga<T extends Number>{
    private final T alas,tinggi;
    public Segitiga(T alas, T tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }
    int getResultAsInt(){
        T alas = this.alas;
        T tinggi = this.tinggi;
        return (alas.intValue()* tinggi.intValue())/2;
    }
    double getResultAsDouble(){
        T alas = this.alas;
        T tinggi = this.tinggi;
        return (alas.doubleValue()* tinggi.doubleValue())/2;
    }
}