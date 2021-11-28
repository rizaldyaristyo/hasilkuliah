package com.PLtelat;
import java.util.Scanner;
//mineDaysConv
class Konvert{
    int tahun,bulan,hari,hari0;
    void prozes(int hari){
        extractedProsez(hari);
    }

    private void extractedProsez(int hari) {
        hari0= hari;
        while (true){
            if (hari >= 365) {
                hari = hari - 365;
                tahun++;
            }else if (hari >= 30) {
                hari = hari - 30;
                bulan++;
            }else{
                this.hari= hari;
                break;
            }
        }
    }

    void showRes(){
        System.out.println(hari0+" Hari = "+tahun+" Tahun "+bulan+" Bulan "+hari+" hari ");
    }
}
public class Main {
    public static void main(String[] args) {
        try{
            Konvert objKonv = new Konvert();
            Scanner Inputan = new Scanner(System.in);
            System.out.print("Jumlah hari : ");
            int Hari = Inputan.nextInt();
            objKonv.prozes(Hari);
            objKonv.showRes();
        }catch (Exception e){
            System.out.println("Something Went Wrong");
        }
    }
}
