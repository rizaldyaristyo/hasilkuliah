package com.PBO2SulitWoiOOP2;
import java.util.Scanner;

class Luas {
    void luas(){
        Scanner Inputan = new Scanner(System.in);
        int jariJari;
        double hasilLuas;

        System.out.print("Input Jari-Jari (cm): ");
        jariJari=Inputan.nextInt();

        hasilLuas = 3.14 * jariJari * jariJari;
        System.out.printf("Hasil Luas Lingkaran: %.2f",hasilLuas);
        //System.exit(0);
    }

}

class Keliling {
    void keliling(){
        Scanner Inputan = new Scanner(System.in);
        int jariJari;
        double hasilKeliling;

        System.out.print("Input Jari-Jari (cm): ");
        jariJari=Inputan.nextInt();

        hasilKeliling = 2 * 3.14 * jariJari;
        System.out.printf("Hasil Keliling Lingkaran: %.2f",hasilKeliling);
        //System.exit(0);
    }

}

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                Scanner Inputan = new Scanner(System.in);
                Keliling klg = new Keliling();
                Luas Las = new Luas();
                int pilihanMenu;
                while(true){
                    System.out.println("\n\nMenu\n1. Keliling\n2. Luas\n3. Keluar\nInput Pilihan: ");
                    pilihanMenu = Inputan.nextInt();
                    switch (pilihanMenu) {
                        case 1 -> klg.keliling();
                        case 2 -> Las.luas();
                        case 3 -> {
                            System.out.println("Exit");
                            System.exit(0);
                        }
                        default -> throw new Exception("Pilihan Tidak ada");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
