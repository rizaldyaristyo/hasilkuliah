package permutasi;

import java.util.ArrayList;
import java.util.Scanner;

public class NonRekursif {
    public static ArrayList<String> permutasi(String stringnya) {
        ArrayList<String> arrList = new ArrayList<>();
        if (stringnya.length() == 0) {
            arrList.add(stringnya);
            return arrList;
        }
        char chrDepan = stringnya.charAt(0);
        String sisa = stringnya.substring(1);
        /*System.out.println("sisa : "+stringnya.substring(1));*/
        for (String stringSisa : permutasi(sisa)) {
            arrList.addAll(Selipan(chrDepan, stringSisa));
        }
        return arrList;
    }
    public static ArrayList<String> Selipan(char ch, String s) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            String hasilSelip = s.substring(0, i) + ch + s.substring(i);
            out.add(hasilSelip);
            /*System.out.println("acak "+i+" : "+hasilSelip);*/
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.println(permutasi(inputan.nextLine()));
    }
}
