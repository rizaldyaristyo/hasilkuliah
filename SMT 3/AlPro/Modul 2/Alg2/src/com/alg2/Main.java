package com.alg2;
import java.util.Scanner;
class LexicoGraphSort{
    /**
     *
     * @param string1 First String to compare with the second one
     * @param string2 Second String to compare with the first one
     * @return negative, zero, or positive integer. if returns negative then string1<string2,
     * else if returns positive then string1>string2,
     * else if returns zero then string1==string2
     */
    int compare(String string1, String string2) {
        for (int i=0; i<string1.length() && i<string2.length(); i++)
            if ((int)string1.charAt(i) != (int)string2.charAt(i)) return ((int)string1.charAt(i)-(int)string2.charAt(i));
        if (string1.length()<string2.length()||string1.length()>string2.length()) return (string1.length()-string2.length());
        else return 0;
    }
    /**
     * Lexicographically Sort Array of Strings with Selection Sort Algorithm
     * @param strArr Array that will going to be Lexicographically Selection Sorted
     * @return String[] of sorted array
     */
    String[] selectSort(String[] strArr){
        int arrLen=strArr.length;
        for(int i = 0; i < arrLen - 1; i++) {
            int min_index = i;
            String minStr = strArr[i];
            for(int j=i+1; j<arrLen; j++) {
                if(compare(strArr[j],minStr) < 0) {
                    minStr = strArr[j];
                    min_index = j;
                }
            }
            if(min_index != i) {
                String temp = strArr[min_index];
                strArr[min_index] = strArr[i];
                strArr[i] = temp;
            }
        } return strArr;
    }
    /**
     * Lexicographically Sort Array of Strings with Bubble Sort ALgorithm
     * @param strArr Array that will going to be Lexicographically Bubble Sorted
     * @return String[] of sorted array
     */
    String[] bubbleSort(String[] strArr){
        String swap;
        boolean stop=false;
        int arrLen= strArr.length;
        while (!stop){
            stop=true;
            for(int i=0; i<arrLen-1; i++){
                if ((compare(strArr[i],strArr[i+1])>0)){
                    swap=strArr[i+1];
                    strArr[i+1]=strArr[i];
                    strArr[i]=swap;
                    stop=false;
                }
            }
        } return strArr;
    }
}

public class Main {
    public static void main(String[] args) {
        LexicoGraphSort lexicoGraphicallySort = new LexicoGraphSort();
        String[] strA={"Lala","Zahra","Dede","Bobo"};
        String[] strB={"Jarvis","Daniel","Qibo","Aldo"};
        String[] joinStr = new String[(strA.length+strB.length)];
        for (int i=0; i<strA.length; i++) joinStr[i]=strA[i]; int j=0;
        for (int i=strA.length; i<joinStr.length; i++){joinStr[i]=strB[j]; j++;}
        System.out.println("Daftar Penumpang");
        for (String s:joinStr) System.out.print(s+" ");
        System.out.println("\nSelect Algorithm:\n 1.Selection Sort\n 2.Bubble Sort");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1 -> joinStr = lexicoGraphicallySort.selectSort(joinStr);
            case 2 -> joinStr = lexicoGraphicallySort.bubbleSort(joinStr);
        }
        for (String i:joinStr) System.out.print(i+" ");
    }
}