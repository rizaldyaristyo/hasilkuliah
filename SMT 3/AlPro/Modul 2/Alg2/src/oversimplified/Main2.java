package oversimplified;
import java.util.Scanner;
class CompareToSort {
    String[] selectSort(String[] strArr){
        int arrLen=strArr.length;
        for(int i = 0; i < arrLen - 1; i++) {
            int min_index = i;
            String minStr = strArr[i];
            for(int j=i+1; j<arrLen; j++) {
                if(strArr[j].compareTo(minStr) < 0) {
                    minStr = strArr[j];
                    min_index = j;
                }
            }
            if(min_index != i) {
                String temp = strArr[min_index];
                strArr[min_index] = strArr[i];
                strArr[i] = temp;
            }
        }return strArr;
    }
    String[] bubbleSort(String[] strArr){
        String swap; boolean stop=false; int arrLen= strArr.length;
        while (!stop){
            stop=true;
            for(int i=0; i<arrLen-1; i++){
                if (strArr[i].compareTo(strArr[i+1])>0){
                    swap=strArr[i+1];
                    strArr[i+1]=strArr[i];
                    strArr[i]=swap;
                    stop=false;
                }
            }
        }return strArr;
    }
}
    public static void main(String[] args) {
        CompareToSort sortWith = new CompareToSort();
        Scanner inputan = new Scanner(System.in);
        String[] StrA = {"Lala", "Zahra", "Dede", "Bobo"}; String[] StrB = {"Jarvis", "Daniel", "Qibo", "Aldo"};
        String[] joinStr = new String[StrA.length + StrB.length];
        System.arraycopy(StrA, 0, joinStr, 0, StrA.length);
        System.arraycopy(StrB, 0, joinStr, StrA.length, StrB.length);
        System.out.println("Daftar Penumpang: ");
        for (String s:joinStr) System.out.print(s+"  ");
        System.out.println("\nSelect Algorithm: \n 1.Selection Sort\n 2.Bubble Sort");
        switch (inputan.nextInt()) {
            case 1 -> joinStr = sortWith.selectSort(joinStr);
            case 2 -> joinStr = sortWith.bubbleSort(joinStr);
        }for (String i:joinStr) System.out.print(i+" ");
    }
}