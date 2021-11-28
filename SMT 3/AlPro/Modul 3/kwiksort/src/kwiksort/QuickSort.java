package kwiksort;


public class QuickSort {
    static void printArray(String[] arr, int size){
        for(int i = 0; i < size; i++) System.out.println((i+1)+". "+arr[i]);
    }

    public static int  partisi(String[] arrayNya, int end){
        String pivotCont = arrayNya[end];
        int pivotIdx = end;
        for (int i=0; i < arrayNya.length; i++){
            for (int j=0; j < arrayNya.length; j++) {
                if (arrayNya[j].compareTo(pivotCont)> 0 && j < pivotIdx) {
                    String temp = arrayNya[j];
                    arrayNya[j] = arrayNya[pivotIdx];
                    arrayNya[pivotIdx] = temp;
                    pivotIdx = j;
                } else if (arrayNya[j].compareTo(pivotCont)< 0 && j > pivotIdx) {
                    String temp = arrayNya[j];
                    arrayNya[j] = arrayNya[pivotIdx];
                    arrayNya[pivotIdx] = temp;
                    pivotIdx = j;
                }
            }
        }
        return pivotIdx;
    }

    public static void sort(String[] arrayNya, int start, int end){
        if (start < end){
            int indexPivot = partisi(arrayNya, end);

            sort(arrayNya, start, indexPivot - 1);
            sort(arrayNya, indexPivot + 1,end);
        }
    }
    public static void main(String[] args) {
        String[] arrayNya = {"gajah","kuda","ikan","ayam","bebek"};
        sort(arrayNya,0,(arrayNya.length)-1);
        printArray(arrayNya, (arrayNya.length)-1);
    }
}
