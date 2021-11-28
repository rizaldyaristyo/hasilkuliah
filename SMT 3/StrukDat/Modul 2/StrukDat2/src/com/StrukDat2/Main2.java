package com.StrukDat2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Main2 {
    public static void main(String[] args) {
        List<String> hewanList = Arrays.asList("Angsa","Bebek","Cicak","Domba","Elang","Gajah");
        ArrayList<String> hewan = new ArrayList<>(hewanList);
        System.out.println(hewan);
        hewan.add("Badak"); hewan.add("Bebek");
        System.out.println(hewan);
        System.out.println("Bebek = "+ Collections.frequency(hewan,"Bebek")
                +"Posisi Index : "+ hewan.indexOf("Bebek")+","+hewan.lastIndexOf("Bebek"));
        hewan.remove(1);
        System.out.println(hewan+"\nIndex ke-0 : "+hewan.get(0)+"\nIndex ke-2 : "+hewan.get(2));
        hewan.remove(0);
        System.out.println(hewan);
        hewan.set(0,"Ular");
        System.out.println(hewan);
        hewan.add(2,"Itik");
        System.out.println(hewan);
        hewan.subList(2,5).clear();
        System.out.println(hewan);
        System.out.println("Elemen Pertama : "+hewan.get(0)+"\nElemen Terakhir : "+hewan.get(hewan.size()-1)
                +"\nJumlah Elemen : "+hewan.size()+"\nIndex Badak : "+ hewan.indexOf("Badak"));
    }
}