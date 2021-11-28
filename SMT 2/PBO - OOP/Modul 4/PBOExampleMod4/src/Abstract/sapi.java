package Abstract;

public class sapi extends hewan{

    @Override
    void setNama(){
        System.out.println("Nama hewan adalah sapi");
    }

    @Override
    void setMakanan(){
        System.out.println("Makanan sapi adalah rumput");
    }

    void setUkuran(){
        System.out.println("ukuran hewan besar");
    }
}