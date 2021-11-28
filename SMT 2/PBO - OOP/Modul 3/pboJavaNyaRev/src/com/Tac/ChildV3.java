// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.Tac;
import com.APBOJavaNyaRev.Company;

public class ChildV3 extends Company {
    public ChildV3(String aa, int bb){
        super(aa,bb);
    }
    public ChildV3(String a){
        super(a);
    }
    public ChildV3(int b){
        super(b);
    }
    public ChildV3(String c, int d, String e){
        super(c,d,e);
    }
    public static void showV3(){
        ChildV3 obj1 = new ChildV3("krisan");
        ChildV3 obj2 = new ChildV3("Desainer",2);
        ChildV3 obj3 = new ChildV3(42);
        ChildV3 obj4 = new ChildV3("Rp.",15," Juta");
        System.out.println("V3\nnama orang      : "+obj1.namaOrang);
        System.out.println("jabatan         : "+obj2.namaJabatan+" level instansi ke-"+obj2.levelJabatan);
        System.out.println("teman sekerja   : "+obj3.jumlahPejabat);
        System.out.println("gaji jabatan    : "+obj4.mataUang+obj4.gajiJabatan+obj4.satuan);

    }
}