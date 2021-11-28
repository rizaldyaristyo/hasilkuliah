package com.soalQuizPBO;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends DataKota {
    public static void main(String[] args) {
        while(true){
            try {
                Scanner Imput = new Scanner(System.in);
                double Limbahm, Airm, Udaram;
                String namaKotam;
                System.out.print("Masukkan jumlah data    : ");
                int i = 0, jmlData = Imput.nextInt();
                DataKota objDataK = new DataKota();
                double[] Totalarr = new double[jmlData], Limbaharr = new double[jmlData], Airarr = new double[jmlData], Udaraarr = new double[jmlData];
                String[] namaKotaarr = new String[jmlData], statTercemar = new String[jmlData];
                while (i < jmlData) {
                    System.out.print("\nMasukkan nama Kota      : ");
                    namaKotam = Imput.next();
                    objDataK.strnamaKota(namaKotam);

                    System.out.print("Masukkan Skor limbah    : ");
                    Limbahm = Imput.nextDouble();
                    objDataK.doubleLimbah(Limbahm);

                    System.out.print("Masukkan polusi air     : ");
                    Airm = Imput.nextDouble();
                    objDataK.doubleAir(Airm);

                    System.out.print("Masukkan polusi udara   : ");
                    Udaram = Imput.nextDouble();
                    objDataK.doubleUdara(Udaram);

                    namaKotaarr[i] = objDataK.namaKota;
                    Limbaharr[i] = objDataK.Limbah;
                    Airarr[i] = objDataK.Air;
                    Udaraarr[i] = objDataK.Udara;
                    objDataK.doubleTotal();
                    Totalarr[i] = objDataK.Total;
                    if (Totalarr[i] < 50) {
                        statTercemar[i] = "Tidak Tercemar";
                    } else {
                        statTercemar[i] = "Tercemar";
                    }
                    i++;
                }
                i = 0;
                System.out.println("Nama Kota     Limbah(40%)     Air(30%)      Udara(30%)       Final Skor      Tercemar");
                while (i < jmlData) {
                    System.out.println(namaKotaarr[i] + "\t\t\t" + Limbaharr[i] +
                            "\t\t\t" + Airarr[i] + "\t\t\t" + Udaraarr[i] + "\t\t\t" + Totalarr[i] + "\t\t" + statTercemar[i]);
                    i++;
                }
                System.exit(0);
            } catch (InputMismatchException e) {
                System.out.println("Dudeee really??? WRONG DATATYPEE DUDEEEE!!!");
            } catch (Exception e){
                System.out.println("Unknown Error...");
                e.printStackTrace();
            }
        }
    }
}
