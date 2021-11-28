// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.Tac;
import com.APBOJavaNyaRev.Company;

public class ChildV2 extends Company {
    public ChildV2(String aa, int bb){
        super(aa,bb);
    }
    public ChildV2(String a){
        super(a);
    }
    public ChildV2(int b){
        super(b);
    }
    public ChildV2(String c, int d, String e){
        super(c,d,e);
    }
    public static void showV2(){
        ChildV2 obj1 = new ChildV2("dahlia");
        ChildV2 obj2 = new ChildV2("Desainer",2);
        ChildV2 obj3 = new ChildV2(42);
        ChildV2 obj4 = new ChildV2("Rp.",15," Juta");
        System.out.println("V2\nnama orang      : "+obj1.namaOrang);
        System.out.println("jabatan         : "+obj2.namaJabatan+" level instansi ke-"+obj2.levelJabatan);
        System.out.println("teman sekerja   : "+obj3.jumlahPejabat);
        System.out.println("gaji jabatan    : "+obj4.mataUang+obj4.gajiJabatan+obj4.satuan);

    }
}