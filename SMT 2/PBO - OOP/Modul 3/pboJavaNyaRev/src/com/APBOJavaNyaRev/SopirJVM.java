// CC BY-NC-SA 4.0 licensed by Rizaldy Aristyo

package com.APBOJavaNyaRev;
import com.Tic.Child;
import com.Tac.*;

public class SopirJVM{

    public static void main(String[] args) {
        System.out.println("\nCompany(Parent)");
        Company objCompany1 = new Company("Orang");
        Company objCompany0 = new Company("Editor",3);
        Company objCompany2 = new Company(18);
        Company objCompany3 = new Company("Rp.",20," Juta");
        System.out.println("\nnama orang      : "+ objCompany1.namaOrang);
        System.out.println("jabatan         : "+ objCompany0.namaJabatan+" level instansi ke-"+ objCompany0.levelJabatan);
        System.out.println("teman sekerja   : "+ objCompany2.jumlahPejabat);
        System.out.println("gaji jabatan    : "+ objCompany3.mataUang+ objCompany3.gajiJabatan+ objCompany3.satuan);

        System.out.println("\n(Child)");
        Child objChild1 = new Child("Orang");
        Child objChild2 = new Child("Desainer",2);
        Child objChild3 = new Child(42);
        Child objChild4 = new Child("Rp.",15," Juta");
        System.out.println("\nnama orang      : "+objChild1.namaOrang);
        System.out.println("jabatan         : "+objChild2.namaJabatan+" level instansi ke-"+objChild2.levelJabatan);
        System.out.println("teman sekerja   : "+objChild3.jumlahPejabat);
        System.out.println("gaji jabatan    : "+objChild4.mataUang+objChild4.gajiJabatan+objChild4.satuan);

        System.out.println("\n(rest of other Childs (2nd-5th))");
        ShowRoom show = new ShowRoom();
        show.showRoom();

    }
}
class ShowRoom{
    void showRoom(){
        ChildV2.showV2();
        ChildV3.showV3();
        ChildV4.showV4();
        ChildV5.showV5();
    }
}