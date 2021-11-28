package com.lineVer;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            Scanner Inputan = new Scanner(System.in);
            System.out.println("===MENU===\n1.)MASUKKAN DATA\n2.)Exit");
            int pilihan = Inputan.nextInt();
            switch (pilihan) {
                case 1 -> {
                    Inputan.nextLine();
                    int[] inNumber = new int[100];
                    String[] inString = new String[100];
                    String stringTemp;
                    boolean loop = true;
                    int a = 0;
                    while (loop) {
                        System.out.print("Input User: ");
                        stringTemp = Inputan.nextLine();
                        if (stringTemp.equals("")) loop = false;
                        else {
                            try {
                                //parseInt = untuk mengubah isi parameter ke Integers
                                //parseInt hanya menerima Integers
                                //"123" != 123
                                //string != int
                                //parameter -> input dari user
                                //input = "123" -> terdiri dari Integers -->parseInt--> Integers
                                //input = "abc" -> terdiri dari Chars -->parseInt--> Error --> throw NumberFormatException
                                //input = "123abc" -> terdiri Integers & Chars -->parseInt--> Error --> throw NumberFormatException
                                int intTemp = Integer.parseInt(stringTemp);
                                inNumber[a] = intTemp;
                            } catch (NumberFormatException masukSiniKuy) {
                                //kalo error = ngeThrow Exception
                                inString[a] = stringTemp;
                            }
                            a++;
                        }
                    }
                    System.out.print("\nArrays Result:\nStrings: ");
                    for (String s : inString)
                        if (s != null)
                            System.out.print(s + " ");
                    System.out.print("\nIntegers: ");
                    for (int i : inNumber)
                        if (i != '\0')
                            System.out.print(i + " ");
                }
                case 2 -> System.exit(0);
                default -> {
                    try{
                        throw new Exception("no Menu");
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        }catch (InputMismatchException e1){
            System.out.println("Salah Input Tipedata");
        }
    }
}