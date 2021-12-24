package com.graphV2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    private int panjangArrayExternal;
    private LinkedList<Integer> linkedList[];

    Graph(int panjangArray) {
        panjangArrayExternal = panjangArray;
        linkedList = new LinkedList[panjangArray];
        for (int i = 0; i < panjangArray; ++i)
            linkedList[i] = new LinkedList();
    }

    void addEdge(int dari, int ke) {
        linkedList[dari].add(ke);
    }

    void DFSBackEnd(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = linkedList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) DFSBackEnd(n, visited);
        }
    }

    void DFS(int input) {
        boolean visited[] = new boolean[panjangArrayExternal];
        DFSBackEnd(input, visited);
    }

    void BFS(int input) {
        boolean visited[] = new boolean[panjangArrayExternal];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[input] = true;
        queue.add(input);
        while (queue.size() != 0) {
            input = queue.poll();
            System.out.print(input + " ");
            Iterator<Integer> i = linkedList[input].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
public class Main2{
    public static void main(String args[]) {
        Graph g = new Graph(12);

        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 5);
        g.addEdge(5, 2);
        g.addEdge(5, 3);
        g.addEdge(5, 7);
        g.addEdge(5, 9);
        g.addEdge(9, 5);
        g.addEdge(9, 8);
        g.addEdge(8, 9);
        g.addEdge(8, 11);
        g.addEdge(11, 10);
        g.addEdge(11, 7);
        g.addEdge(7,  11);
        g.addEdge(7, 6);
        g.addEdge(6, 7);
        g.addEdge(1, 4);
        g.addEdge(4, 6);

        int searchThis;

        while (true){
            Scanner inputan = new Scanner(System.in);
            searchThis = inputan.nextInt();
            System.out.print("\nDFS: ");
            g.DFS(searchThis);
            System.out.print("\nBFS: ");
            g.BFS(searchThis);
            System.out.println();
        }
    }
}