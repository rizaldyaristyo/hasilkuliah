package com.StrukDat2;
class Node{
    int data;
    Node next;
    public Node (int data){
        this.data=data;
    }
}
class LinkedList{
    Node node;
    public void add(int data){
        if (node == null) node=new Node(data);
        Node current = node;
        while(current.next!=null) current=current.next;
        current.next=new Node(data);
    }
    public void showData(){
        System.out.println();
        if (node==null){System.out.print("Empty"); return;}
        Node current=node;
        while (current.next!=null){
            current=current.next;
            int data=current.data;
            System.out.print(data+",");
        }
    }
    public void sortList() {
        Node current = node, index = null;
        int temp;
        if (node != null){
            while (current != null) {
                while (index != null) {
                    if (current.data>index.data) {
                        temp = current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                    index = index.next;
                }
                index = current.next;
                current = current.next;
            }
        }
    }
}
public class Main3 {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.add(8);link.add(7);link.add(1);link.add(4);
        link.add(6);link.add(2);link.add(3);
        link.showData();
        link.sortList();
        link.showData();
    }
}