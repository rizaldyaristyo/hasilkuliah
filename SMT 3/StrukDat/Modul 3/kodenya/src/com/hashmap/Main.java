package com.hashmap;


import java.util.*;

class DataPraktikan {
    HashMap<String, String> tabelSesiLogin = new HashMap<>();

    public void login(){
        Scanner inputan = new Scanner(System.in);
        boolean logdin = false;
        tabelSesiLogin.put("admin@umm.ac.id","123");
        while (!logdin){
            System.out.print("==Login==\nMasukkan EMail Terdaftar: ");
            String email = inputan.nextLine();
            System.out.print("Masukkan Password: ");
            String passwd = inputan.nextLine();
            if (email.contains("@umm.ac.id"))
                if (tabelSesiLogin.containsKey(email))
                    if (tabelSesiLogin.get(email).equals(passwd)) logdin=true;
                    else System.out.println("[ERR] Password Salah!");
                else System.out.println("[ERR] EMail Tidak Ditemukan!");
            else System.out.println("[ERR] Bukan EMail yang Benar!");
        }
    }

    public int totalEmail(HashMap tabelData){
        int i=0; for (Object nimAsKey: tabelData.keySet()) i++;
        return i;
    }

    public boolean tambahData(HashMap tabelData, String nimPraktikan, String namaAsisten){
        System.out.println("subs: "+(nimPraktikan.substring(0,2)));
        if (!(nimPraktikan.substring(0,2).equals("IF"))) return false;
        System.out.println("entered: "+nimPraktikan);
        if (tabelData.containsKey(nimPraktikan)) return false;
        tabelData.put(nimPraktikan,namaAsisten);
        return true;
    }

    public void tampil(HashMap tabelData){
        System.out.println("\n\nTotal Data yang Tersimpan : "+ totalEmail(tabelData));
        for (Object nimAsKey: tabelData.keySet()) System.out.println("NIM : "+nimAsKey+", Nama Asisten : "+tabelData.get(nimAsKey));
        System.out.println("--end--\n\n");
    }

    public void listNimPraktikan(HashMap tabelData){
        System.out.println("\n\nTotal NIM yang Tersimpan : "+ totalEmail(tabelData));
        for (Object nimAsKey: tabelData.keySet()) System.out.println("NIM : "+nimAsKey);
        System.out.println("--end--\n\n");
    }

    public void listNamaAsisten(HashMap tabelData){
        System.out.println("\n\nTotal Nama yang Tersimpan : "+ totalEmail(tabelData));
        for (Object nimAsKey: tabelData.keySet()) System.out.println("Nama Asisten : "+tabelData.get(nimAsKey));
        System.out.println("--end--\n\n");
    }

    public boolean hapusData(HashMap tabelData, String nimPraktikan){
        if (tabelData.containsKey(nimPraktikan)){
            tabelData.remove(nimPraktikan);
            return true;
        }else return false;
    }

    public void editData(HashMap tabelData, String nimPraktikan, String namaPraktikan){
        if (tabelData.containsKey(nimPraktikan)){
            tabelData.put(nimPraktikan,namaPraktikan);
            System.out.println("[OK!] Data untuk NIM "+nimPraktikan+" telah berhasil diubah!");
        }else System.out.println("[ERR] NIM "+nimPraktikan+" tidak ditemukan!");
    }

    public void dupeChecker(HashMap tabelData){
        int i=0;
        for (Object nimAsKey: tabelData.keySet()){
            for (Object nestKey: tabelData.keySet()){
                if (!(nimAsKey.equals(nestKey))) {
                    if (tabelData.get(nimAsKey).equals(tabelData.get(nestKey))) {
                        i++;
                        System.out.print(tabelData.get(nimAsKey) + ", ");
                    }
                }
            }
        }
        if (i>1) System.out.println("\nData Duplikat Sebanyak: "+i+" Data");
    }

}

public class Main{
    public static void main(String[] args) {
        HashMap<String, String> tabelData = new HashMap<String, String>();
        tabelData.put("IF202110370523","Yusup");
        tabelData.put("IF202110370524","Yusup");
        DataPraktikan dataNya = new DataPraktikan();
        try {
            dataNya.login();
            while (true){
                Scanner inputan = new Scanner(System.in);
                String namaPraktikan;
                String nimPraktikan;
                System.out.print("""
                        == Menu Entri Data Praktikan ==
                        1.) Entri Data
                        2.) Tampilkan Data Tersimpan
                        3.) Tampilkan NIM Tersimpan
                        4.) Tampilkan Nama Tersimpan
                        5.) Jumlah Data Tersimpan
                        6.) Hapus Data Tersimpan
                        7.) Edit Data Tersimpan
                        8.) Tampilkan Data Duplikat
                        9.) Log-Out

                        Input:""");
                switch (inputan.nextInt()) {
                    case 1 -> {
                        boolean stop = false;
                        while (!stop) {
                            inputan.nextLine(); // Makan newline
                            System.out.print("Masukkan NIM : ");
                            nimPraktikan = inputan.nextLine();
                            System.out.print("Masukkan Nama : ");
                            namaPraktikan = inputan.nextLine();
                            if (dataNya.tambahData(tabelData, nimPraktikan, namaPraktikan))
                                System.out.println("[OK!] Data BERHASIL Ditambahkan!");
                            else System.out.println("[ERR] Data GAGAL Ditambahkan!");
                            System.out.print("Berhenti Entri Data? (y/n): ");
                            String confirm = inputan.next();
                            if (confirm.equals("Y") || confirm.equals("y")) stop = true;
                        }
                    }
                    case 2 -> dataNya.tampil(tabelData);
                    case 3 -> dataNya.listNimPraktikan(tabelData);
                    case 4 -> dataNya.listNamaAsisten(tabelData);
                    case 5 -> {
                        System.out.println("Jumlah Data yang Tersimpan: "+dataNya.totalEmail(tabelData));
                    }
                    case 6 -> {
                        inputan.nextLine(); // Makan newline
                        System.out.println("Masukkan NIM Data yang Ingin Dihapus");
                        nimPraktikan=inputan.nextLine();
                        if(dataNya.hapusData(tabelData,nimPraktikan)){
                            System.out.println("[OK!] Data Berhasil dihapus!");
                        }else System.out.println("[ERR] Data Gagal dihapus!");
                    }
                    case 7 -> {
                        inputan.nextLine(); // Makan newline
                        System.out.print("Masukkan NIM Data yang ingin diubah: ");
                        nimPraktikan=inputan.nextLine();
                        System.out.print("Masukkan Nama Data yang ingin diubah: ");
                        namaPraktikan=inputan.nextLine();
                        dataNya.editData(tabelData,nimPraktikan,namaPraktikan);
                    }
                    case 8 -> {
                        dataNya.dupeChecker(tabelData);
                    }
                    default -> System.exit(0);
                }
            }
        }catch (Exception e){
            System.out.println("Salah input kah?");
            System.exit(-1);
        }

    }
}