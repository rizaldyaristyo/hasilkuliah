package com.tree;

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
    void preOrder(Node node) {
        if (node!=null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.NewNode("20");
        binaryTree.NewNode("2");
        binaryTree.NewNode("25");
        binaryTree.NewNode("37");
        binaryTree.NewNode("16");
        System.out.println("\npreOrder  : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\ninOrder   : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\npostOrder : ");
        binaryTree.postOrder(binaryTree.root);


        binaryTree = new BinaryTree();
        binaryTree.NewNode("A");
        binaryTree.NewNode("B");
        binaryTree.NewNode("C");
        binaryTree.NewNode("D");
        binaryTree.NewNode("E");
        System.out.println("\npreOrder  : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\ninOrder   : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\npostOrder : ");
        binaryTree.postOrder(binaryTree.root);

    }
}
