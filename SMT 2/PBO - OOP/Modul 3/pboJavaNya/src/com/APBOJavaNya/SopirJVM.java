package com.APBOJavaNya;
import com.Tac.Child;

public class SopirJVM{

    public static void main(String[] args) {
        System.out.println("Konst");
        Konst objKonst = new Konst();
        objKonst.jabatan(3);
        objKonst.jabatan(3,2000000);
        objKonst.jabatan2(12);
        objKonst.jabatan2(12,2500000);
        System.out.println("Child");
        Child objChild = new Child();
        objChild.jabatan3(4);
        objChild.jabatan3(4,1500000);
        objChild.jabatan4(2);
        objChild.jabatan4(2,2000000);
    }
}
