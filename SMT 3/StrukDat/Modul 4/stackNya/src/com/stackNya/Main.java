package com.stackNya;

import java.util.Scanner;

class Stack{
    int maxSize;
    char[] stackArray;
    int top;

    public Stack(int a){
        maxSize=a;
        stackArray=new char[maxSize];
        top=-1;
    }
    public void push(char chr){
        stackArray[++top]=chr;
    }
    public char pop(){
        return stackArray[top--];
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner inputan=new Scanner(System.in);
        System.out.print("Masukkan Input: ");
        String input = inputan.nextLine();
        Stack stacknya=new Stack(input.length());
        for (int i=0;i<input.length();i++) stacknya.push(input.charAt(i));
        System.out.print("Reversed: ");
        for (int i=0;i<input.length();i++) System.out.print(stacknya.pop());

    }
}
