package com.praktikProgLan2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        String[] book = {"A Book, Malang. 2021"};
        String[] place = {"Batu","Malang","Surabaya"};
        String inName;
        String inFrom;
        int inDate,j;

        try {
            System.out.println("Wellcome\n Input Book =");
            System.out.print("Nama : ");
            inName = Inputan.nextLine();
            for (String i : book) {
                if (inName.equals(i.split(",")[0])) {
                    throw new Exception("Nama Buku Duplikat!");
                }
            }
            System.out.print("From : ");
            inFrom = Inputan.nextLine();
            j=1;
            for (String i : place) {
                if (!inFrom.equals(i)) {
                    j++;
                    j++;
                }
                if (j > place.length){
                    throw new Exception("Hanya untuk buku dari Batu, Malang, atau Surabaya!");
                }
            }
            System.out.print("Date : ");
            inDate = Inputan.nextInt();
            Inputan.close();
            if (inDate<2018||inDate>2020) {
                throw new Exception("Hanya untuk buku terbitan 2018-2020!");
            }
            System.out.println("Menambahkan Buku Sukses!");
            j=0;
            for (String i : book) {
                System.out.println(i);
                j++;
            }
            book[j-1] = String.format("%s, %s. %d", inName, inFrom, inDate);
            System.out.println(book[j-1]);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
