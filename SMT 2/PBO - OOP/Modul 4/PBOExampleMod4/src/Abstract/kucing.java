package Abstract;

public class kucing extends hewan {

    @Override
    void setNama(){
        System.out.println("Nama hewan adalah Kucing");
    }

    @Override
    void setMakanan(){
        System.out.println("Makanan kucing adalah ikan");
    }

    void setWarna(){
        System.out.println("Warna putih");
    }
}
