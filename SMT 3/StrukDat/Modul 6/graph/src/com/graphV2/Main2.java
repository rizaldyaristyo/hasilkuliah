package com.graphV2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    int panjangArrayExternal;
    LinkedList<Integer>[] linkedList;

    Graph(int panjangArray) {
        panjangArrayExternal = panjangArray;
        linkedList = new LinkedList[panjangArray];
        for (int i = 0; i < panjangArray; ++i) linkedList[i] = new LinkedList();
    }

    void directedGraph(int dari, int ke) {
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
        Graph graph = new Graph(12);

        graph.directedGraph(1, 2);
        graph.directedGraph(1, 4);
        graph.directedGraph(2, 1);
        graph.directedGraph(2, 5);
        graph.directedGraph(4, 6);
        graph.directedGraph(5, 2);
        graph.directedGraph(5, 3);
        graph.directedGraph(5, 7);
        graph.directedGraph(5, 9);
        graph.directedGraph(6, 7);
        graph.directedGraph(9, 5);
        graph.directedGraph(9, 8);
        graph.directedGraph(8, 9);
        graph.directedGraph(8, 11);
        graph.directedGraph(7, 6);
        graph.directedGraph(7,  11);
        graph.directedGraph(11, 7);
        graph.directedGraph(11, 10);

        int searchThis;
        while (true){
            Scanner inputan = new Scanner(System.in);
            searchThis = inputan.nextInt();
            System.out.print("\nDFS: ");
            graph.DFS(searchThis);
            System.out.print("\nBFS: ");
            graph.BFS(searchThis);
            System.out.println();
        }
    }
}