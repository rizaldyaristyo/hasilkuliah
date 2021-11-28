package com.PBOExceptTheStage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RekapNilai {
    Scanner Inputan = new Scanner(System.in);

    private int nilai;
    private String matkul;
    private String nama;

    public int getNilai() {
        return nilai;
    }
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
    public String getMatkul() {
        return matkul;
    }
    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    void masukkan() {
        try {
            File buatFile = new File("hasilRekap.txt");
            if (buatFile.createNewFile()) {
                System.out.println("File created: " + buatFile.getName());
            } else {
                if (buatFile.delete()) {
                    System.out.println("Identical file detected\nOverwritting = " + buatFile.createNewFile() + "...");
                } else {
                    System.out.println("Failed to delete the file.");
                    System.exit(5);
                }
            }
            int i = 0;
            boolean loop = true;
            FileWriter tulisOut = new FileWriter("hasilRekap.txt", true);
            tulisOut.write("===REKAP NILAI===\n");
            while (loop) {
                System.out.print("===DATA KE-" + (i + 1) + "===");
                System.out.print("\nMasukkan Nama " + (i + 1) + "   : ");
                setNama(Inputan.nextLine());
                System.out.print("Masukkan Matkul " + (i + 1) + " : ");
                setMatkul(Inputan.nextLine());
                boolean negatif=true;
                while (negatif){
                    System.out.print("Masukkan Nilai " + (i + 1) + "  : ");
                    setNilai(Inputan.nextInt());
                    if (getNilai()>=0){
                        negatif=false;
                    }else {
                        System.out.println("---Nilai tidak boleh negatif!---");
                    }
                }

                tulisOut.write("\nnama  : " + getNama() + "\n" + "matkul: " + getMatkul() + "\n" + "nilai : " + getNilai() + "\n");

                i++;
                System.out.print("Masukkan Nilai Berikutnya? (default:Y/n) : ");
                char choice = Inputan.next().charAt(0);
                switch (choice) {
                    case 'n':
                    case 'N':
                        loop = false;
                        tulisOut.close();
                    default:
                        Inputan.nextLine();
                        break;
                }
            }
        } catch (InputMismatchException salahinput) {
            System.out.println("Wrong dataType!!!");
            System.exit(1);
        } catch (IOException ioerror) {
            System.out.println("IO Error occured");
            System.exit(2);
        } catch (Exception idk) {
            System.out.println("idk what's happened, let's check your code again shall we?");
            System.exit(3);
        } finally {
            System.out.println("---File Saved!---");
        }

    }

    void keluaran() {
        try {
            Scanner tulisMasuk = new Scanner(new File("hasilRekap.txt"));
            System.out.println("\n===BEGINNING OF FILE===\n");
            if(tulisMasuk.hasNextLine()){
                while (tulisMasuk.hasNextLine()) {
                    System.out.println(tulisMasuk.nextLine());
                }
            }else{
                System.out.println("---File Empty!---");
            }
        } catch (IOException e) {
            System.out.println("File IO Error!");
            System.exit(1);
        } finally {
            System.out.println("\n===END OF FILE===\n---Output Shown Successfully---");
        }
    }

}
