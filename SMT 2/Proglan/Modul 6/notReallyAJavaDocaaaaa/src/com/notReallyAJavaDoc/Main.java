package com.notReallyAJavaDoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Ananda Rizaldy Aristyo
 * @since 1.0
 * @version 1.2
 */
class StringIntFilter{
    /**
     * acts as an internal filtering void method that can be called into main method directly
     * or imported to another external method via external classes, it differs Strings Integers
     * from one input loop and assign them to the most relevant array dataType then writes them
     * into a txt file as a logNote which can be accessed next time.
     * Note:
     *  Not an API intended for another project, so we don't expect any param and return values
     *  if it is, then the next version will have the parameters needed as input or equivalent
     * @throws NumberFormatException if inputs aren't in form of int dataType
     * @exception NumberFormatException to parse inputs as Integer datatype
     * @exception ArrayIndexOutOfBoundsException to anticipate Array Overload
     * @param filePath File write path must be provided as a parameter in this method to be then written into
     * @param arrSize Array size needs to be provided as this method doesn't include Dynamic Arrays
     * no @return statement as void methods doesn't return any value
     */
    public void stringintFilters(String filePath,int arrSize){
        try {
            int[] inNumber = new int[arrSize];
            String[] inString = new String[arrSize];
            String stringTemp;
            boolean loop = true;
            int a = 0;
            while (loop) {
                Scanner Inputan = new Scanner(System.in);
                System.out.print("Input User: ");
                stringTemp = Inputan.nextLine();
                if (stringTemp.equals("")) loop = false;
                else {
                    try {
                        int intTemp = Integer.parseInt(stringTemp);
                        inNumber[a] = intTemp;
                    } catch (NumberFormatException masukSiniKuy) {
                        inString[a] = stringTemp;
                    }a++;
                }
            }
            FileWriter tulisOut = new FileWriter(filePath, true);
            System.out.print("\nArrays Result:\nStrings: ");
            tulisOut.write("\nArrays Result:\nStrings: ");
            for (String s : inString) if (s != null) {
                tulisOut.write(s + " ");
                System.out.print(s + " ");
            }
            System.out.print("\nIntegers: ");
            tulisOut.write("\nIntegers: ");
            for (int i : inNumber) if (i != '\0') {
                tulisOut.write(i + " ");
                System.out.print(i + " ");
            }
            tulisOut.close();
        } catch (ArrayIndexOutOfBoundsException ArrE) {
            System.out.println("Arraynya gacukup gan!");
            System.exit(1);
        } catch (Exception dllE){
            System.out.println("idk what's happening, check your code again");
            System.exit(1);
        }
    }
}

class LoadLast{
    /**
     * loads last written filtered Strings and Integers
     * by the stringintFilters() method (Provided by this class)
     * and prints it to the Command Line Interface
     * Note:
     *  Not an API intended for another project, so we don't expect any param and return values
     *  if it is, then the next version will have the parameters needed as input or equivalent
     * @throws FileNotFoundException if inputted data is the wrong datatype
     * @exception FileNotFoundException to handle file call that doesn't exist
     * @param filePath File scan path must be provided as a parameter in this method to be then scanned from
     * no @return statement as void methods doesn't return any value
     */
    public void loader(String filePath) throws FileNotFoundException{
            Scanner Outputan = new Scanner(new File(filePath));
            if (Outputan.hasNextLine()) while (Outputan.hasNextLine()) System.out.println(Outputan.nextLine());
            else System.out.println("---File Empty!---");
    }
}

public class Main {
    public static void main(String[] args) {
        while (true){
            Scanner Inputan = new Scanner(System.in);
            StringIntFilter objFil = new StringIntFilter();
            LoadLast objLod = new LoadLast();
            System.out.print("\n\n===MENU===\n1.) Masukkan Data\n2.) Lihat Hasil Sebelumnya\npilihan: ");
            String loadFileName = "filteredStringsInts.txt";
            int arraySize = 100;
            try {
                int pilihan = Inputan.nextInt();
                switch (pilihan) {
                    case 1 -> objFil.stringintFilters(loadFileName,arraySize);
                    case 2 -> {
                        try {
                            objLod.loader(loadFileName);
                        } catch (FileNotFoundException fnfE) {
                            System.out.println("Belum Pernah membuat data sebelumnya!");
                        }
                    }
                    default -> System.exit(0);
                }
            }catch (InputMismatchException imE) {
                System.out.println("Wrong datatype");
            }
        }
    }
}