package com.PBOExceptTheStage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RekapNilai objRek = new RekapNilai();
        Scanner Inputan = new Scanner(System.in);
        try{
            while (true) {
                System.out.print("\n===MENU===\n1.)Rekap Nilai\n2.)Baca Hasil\n3.)Keluar\nMasukkan pilihan : ");
                int choice = Inputan.nextInt();
                switch (choice) {
                    case 1 -> objRek.masukkan();
                    case 2 -> objRek.keluaran();
                    case 3 -> System.exit(0);
                }
            }
        } catch (InputMismatchException salahinput) {
            System.out.println("Wrong dataType!");
        } catch (Exception idk) {
            System.out.println("idk what's happened, let's check your psvm again shall we?");
            System.exit(3);
        } finally {
            System.out.println("File Saved!");
        }
    }
}
