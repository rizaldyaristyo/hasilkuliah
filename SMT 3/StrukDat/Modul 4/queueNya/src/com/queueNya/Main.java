package com.queueNya;

class Link{
    int dData;
    Link next;

    public Link(int d){
        dData=d;
    }
    public void displayLink(){
        System.out.print(dData+" ");
    }
}

class FirstLastList{
    Link first;
    Link last;

    public FirstLastList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertLast(int dd){
        Link newLink = new Link(dd);
        if(isEmpty())first=newLink;
        else last.next=newLink;
        last=newLink;
    }

    public int deleteFirst(){
        int temp=first.dData;
        if (first.next==null) last=null;
        first=first.next;
        return temp;
    }

    public void displayList(){
        Link current = first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println();
    }

    public void displayCurrent(){
        Link current=first;
        if(current!=null) current.displayLink();
        else System.out.print("Queue Head is Empty!");
    }

    public int queueSize(){
        Link current = first;
        int sizeNya=0;
        while (current!=null) {
            sizeNya++;
            current=current.next;
        }
        return sizeNya;
    }
}

class LinkQueue{ //enqueue[ok] dequeue[ok] peek[ok] isEmpty[ok] size[ok]
    FirstLastList theList;
    public LinkQueue(){
        theList=new FirstLastList();
    }
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    public void enqueue(int j){
        theList.insertLast(j);
    }
    public void dequeue(){
        System.out.println(theList.deleteFirst()+" dequeued");
    }
    public void displayQueue(){
        System.out.print("Queue (Head-->Tail) : ");
        theList.displayList();
    }
    public void peek(){
        System.out.print("peek: ");
        theList.displayCurrent();
    }
    public void size(){
        System.out.println("\nsize: "+theList.queueSize());
    }
}

public class Main {

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.enqueue(10);
        queue.enqueue(40);
        queue.displayQueue();
        queue.peek();
        queue.size();
        System.out.println(queue.isEmpty());
        queue.dequeue();
        queue.displayQueue();
        queue.peek();
        queue.size();
        System.out.println("isEmpty: "+queue.isEmpty());
        queue.dequeue();
        queue.displayQueue();
        queue.peek();
        queue.size();
        System.out.println("isEmpty: "+queue.isEmpty());
    }
}
