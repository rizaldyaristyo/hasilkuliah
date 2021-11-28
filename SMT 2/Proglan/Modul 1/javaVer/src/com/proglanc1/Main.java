package com.proglanc1;
import java.util.Scanner;
//spc char used ─ └ ├ │
public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        String NIM, IfNIM = "10370311";
        int i=0;
        while (i==0) {
            try {
                System.out.println("Masukkan NIM");
                System.out.print("\t└───> ");
                NIM = Inputan.nextLine();

                if (NIM.length() > 15) {
                    throw new Exception("!!! NIM terdeteksi lebih dari 15 digit !!!");
                } else if (NIM.length() < 15) {
                    throw new Exception("!!! NIM terdeteksi kurang dari 15 digit !!!");
                } else {
                    char[] NIMcmp = new char[15];
                    NIM.getChars(4, 12, NIMcmp, 0);
                    String NIMcmpS = String.valueOf(NIMcmp).trim();

                    if (!IfNIM.equals(NIMcmpS)) {
                        throw new Exception("!!! NIM yang dimasukkan khusus NIM Informatika !!!");
                    } else {
                        System.out.println("\nNIM Informatika Diterima!");
                        System.out.println("\tNIM yang diinputkan: " + NIM);
                        i++;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

/* Check tool if needed
System.out.println("\n==  POST CHECK  ==");
System.out.println("Cek String IfNIM    : /" + IfNIM + "/         @" + IfNIM.length() + "Digits");
System.out.println("Cek String NIMcmpS  : /" + NIMcmpS + "/         @" + NIMcmpS.length() + "Digits");
System.out.println("Cek String NIM      : " + NIM + "    @" + NIM.length() + "Digits");
System.out.println(" DONE ───> Equation IfNIM with NIMcmpS returns " + IfNIM.equals(NIMcmpS) + "");
*/
