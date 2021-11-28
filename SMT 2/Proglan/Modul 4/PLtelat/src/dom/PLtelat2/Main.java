package dom.PLtelat2;
import java.util.Scanner;
//mineSortie
class Sortie{
    int besarArray = 5;
    int[] nData = new int[besarArray];
    void collect(){
        Scanner Inputan = new Scanner(System.in);
        for (int i=0; besarArray-1>=i; i++){
            System.out.print("Data ke "+(i+1)+" : ");
            nData[i] = Inputan.nextInt();
        }
    }
    void sortz(){
        int swap;
        boolean berhenti = false;
        while(!berhenti){
            berhenti = true;
            for (int i = 0; besarArray-2 >= i; i++) {
                if (nData[i] > nData[i + 1]) {
                    swap = nData[i + 1];
                    nData[i + 1] = nData[i];
                    nData[i] = swap;
                    berhenti = false;
                }
            }
        }
    }
    //mineSortieShow
    void showRes(){
        for (int i: nData) {
            System.out.print(i+" ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Sortie objSort = new Sortie();
        objSort.collect();
        objSort.sortz();
        objSort.showRes();
    }
}
