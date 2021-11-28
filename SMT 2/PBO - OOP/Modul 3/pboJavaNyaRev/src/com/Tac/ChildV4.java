// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.Tac;
import com.APBOJavaNyaRev.Company;

public class ChildV4 extends Company {
    public ChildV4(String aa, int bb){
        super(aa,bb);
    }
    public ChildV4(String a){
        super(a);
    }
    public ChildV4(int b){
        super(b);
    }
    public ChildV4(String c, int d, String e){
        super(c,d,e);
    }
    public static void showV4(){
        ChildV4 obj1 = new ChildV4("lati");
        ChildV4 obj2 = new ChildV4("Editor",3);
        ChildV4 obj3 = new ChildV4(18);
        ChildV4 obj4 = new ChildV4("Rp.",20," Juta");
        System.out.println("V4\nnama orang      : "+obj1.namaOrang);
        System.out.println("jabatan         : "+obj2.namaJabatan+" level instansi ke-"+obj2.levelJabatan);
        System.out.println("teman sekerja   : "+obj3.jumlahPejabat);
        System.out.println("gaji jabatan    : "+obj4.mataUang+obj4.gajiJabatan+obj4.satuan);

    }
}