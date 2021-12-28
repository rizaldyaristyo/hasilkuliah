//DISCONTINUED


package com.discontinued.sequential;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MultiThread extends Thread{
    public void run(){

    }
}

// Jenis Brute Force: MultiThread Sequential Search
public class Main {
    void linearSearch(String searchee, String[] wordlist){
        for (int a=0;a<wordlist.length;a++) if (searchee.equals(wordlist[a])){
            System.out.println("Ditemukan pada kata ke-"+a);
            return;
        }
        System.out.println("Kata Tidak Ditemukan!");
    }

    void threadingSeq(String searchee, String[] wordlist){
        Thread t1 = new Thread();
    }

    public static void main(String[] args) {
        try{
            File fileNya = new File("/home/kblk/Desktop/minirockyou.txt");
            Scanner iteratorNya = new Scanner(fileNya);
            System.out.println("File Ditemukan!\nInitiating...");
            int jumlahKata=-1;
            while (true){
                String line = iteratorNya.nextLine();
                jumlahKata++;
                if(line.equals("=-=-=-endoffileindicator-=-=-=")) break;
            }
            String[] wordlist = new String[jumlahKata];
            iteratorNya = new Scanner(fileNya);
            for (int a = 0;a<jumlahKata;a++)wordlist[a]=iteratorNya.nextLine();

            System.out.println("Jumlah Kata: "+jumlahKata);
            System.out.print("""
                    == MENU ==
                    1. Ordinary Linear Search
                    2. Multi Threaded Sequential Search
                    *. Exit
                    Pilihan: """);
            Scanner inputan = new Scanner(System.in);
            String choice = inputan.nextLine();
            String forThis;
            switch (choice){
                case "1"->{
                    System.out.println("Masukkan Kata yang Ingin dicari");
                    forThis = inputan.nextLine();
                }
                case "2"->{
                    System.out.println("Masukkan Kata yang Ingin dicari");
                    forThis = inputan.nextLine();
                }
            }
        }catch(FileNotFoundException fileNotFoundException){
            System.out.println("File Tidak Ditemukan!");
        }catch (Exception e){
            System.exit(0);
        }
        
    }

}
