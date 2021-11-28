// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.Tac;
import com.APBOJavaNyaRev.Company;

public class ChildV5 extends Company {
    public ChildV5(String aa, int bb){
        super(aa,bb);
    }
    public ChildV5(String a){
        super(a);
    }
    public ChildV5(int b){
        super(b);
    }
    public ChildV5(String c, int d, String e){
        super(c,d,e);
    }
    public static void showV5(){
        ChildV5 obj1 = new ChildV5("awar");
        ChildV5 obj2 = new ChildV5("Editor",3);
        ChildV5 obj3 = new ChildV5(18);
        ChildV5 obj4 = new ChildV5("Rp.",20," Juta");
        System.out.println("V5\nnama orang      : "+obj1.namaOrang);
        System.out.println("jabatan         : "+obj2.namaJabatan+" level instansi ke-"+obj2.levelJabatan);
        System.out.println("teman sekerja   : "+obj3.jumlahPejabat);
        System.out.println("gaji jabatan    : "+obj4.mataUang+obj4.gajiJabatan+obj4.satuan);

    }
}