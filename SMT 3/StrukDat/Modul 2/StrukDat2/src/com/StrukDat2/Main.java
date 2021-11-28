package com.StrukDat2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();

        data.add("Sapi");
        data.add("Kelinci");
        data.add("Kambing");
        data.add("Unta");
        data.add("Domba");

        data.remove(1);
        data.remove(1);
        data.remove(1);

        System.out.println(data);
    }
}
