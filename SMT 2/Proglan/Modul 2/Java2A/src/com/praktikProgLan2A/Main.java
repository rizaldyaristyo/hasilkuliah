package com.praktikProgLan2A;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        String noHp;
        char[] inPulsa = new char[1];
        String[] pulsa = {"5000","10000","20000","15000","50000"};
        int j=0;


        try{
            System.out.print("Masukkan Nomor HP : ");
            noHp = Inputan.nextLine();
            if (noHp.length() < 12) {
                throw new Exception("Nomor Hp yang dimasukan salah");
            }
            System.out.println("Daftar Pulsa: ");
            for(String i : pulsa){
                j++;
                System.out.println(j+". "+i);
            }
            System.out.println("Masukkan Pulsa : ");
            inPulsa[0] = Inputan.next().trim().charAt(0);
            if (inPulsa[0]=='1'||inPulsa[0]=='2'||inPulsa[0]=='3'||inPulsa[0]=='4'||inPulsa[0]=='5'){
                System.out.println("Selamat transaksi berhasil");
            }else{
                throw new Exception("Pulsa Tidak Ada!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}