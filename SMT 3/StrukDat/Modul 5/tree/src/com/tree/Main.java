package com.tree;

import java.util.Scanner;

class Node{
    String data;
    Node left;
    Node right;
    public Node(String data){
        this.data = data;
    }
}

class BinaryTree{
    public Node root;

    public void NewNode(String data){
        root=NewNode(root,new Node(data));
    }
    private Node NewNode(Node root, Node newData){
        if (root == null){
            root=newData;
            return root;
        }
        if (newData.data.compareTo(root.data)<0) {
            root.left=NewNode(root.left,newData);
        }else{
            root.right=NewNode(root.right,newData);
        }
        return root;
    }

    void showTree(Node node, StringBuilder stringBuilder, String garisLurus, String garisCabang, boolean garisNggaSih,boolean firstNggaSih) {
        if (node!=null){
            stringBuilder.append(garisLurus);
            stringBuilder.append(garisCabang);
            if (firstNggaSih) stringBuilder.append("    ");
            stringBuilder.append(node.data);
            stringBuilder.append("\n");

            StringBuilder tambahGarisLurus = new StringBuilder(garisLurus);
            if (garisNggaSih) tambahGarisLurus.append("│  ");
            else tambahGarisLurus.append("    ");

            String garisLurusBaru = tambahGarisLurus.toString();
            String tunjukKanan = "└──";
            String tunjukKiri;
            if (node.right != null) tunjukKiri = "├──";
            else tunjukKiri = "└──";

            System.out.println(stringBuilder);

            showTree(node.left,stringBuilder,garisLurusBaru,tunjukKiri,node.right!=null,false);
            showTree(node.right,stringBuilder,garisLurusBaru,tunjukKanan,false,false);
        }
    }

    void preOrder(Node node) {
        if (node!=null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }
    public void postOrder(Node node) {
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        StringBuilder stringBuilder = new StringBuilder();
        Scanner inputan = new Scanner(System.in);
        System.out.print("Input: ");
        String inputUser = inputan.nextLine();
        for (int i=0;i<inputUser.length();i++) binaryTree.NewNode(String.valueOf(inputUser.charAt(i)));
        binaryTree.showTree(binaryTree.root,stringBuilder,"","",false,true);
        System.out.println("\npreOrder  : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\ninOrder   : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\npostOrder : ");
        binaryTree.postOrder(binaryTree.root);
    }
}
