package com.discontinued.shortest;

import java.util.LinkedList;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    LinkedList<Edge> [] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge); //for directed graph
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " + list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }
    }
}

class Brute{
    int forceShortest(String source){
        switch (source){
            case "1234"->{

            }
        }
        return 0;
    }
}

public class Main {
    static void permutate(String str, String answer) {
        if (str.length() == 0) {
            System.out.print(answer + " ");
            Brute brute = new Brute();
            brute.forceShortest(answer);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permutate(ros, answer + ch);
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(13);
        String string = "1234";
        graph.addEgde(1,2,100);
        graph.addEgde(1,4,70);
        graph.addEgde(1,3,150);
        graph.addEgde(2,1,100);
        graph.addEgde(2,3,70);
        graph.addEgde(2,4,150);
        graph.addEgde(3,1,150);
        graph.addEgde(3,2,80);
        graph.addEgde(3,4,100);
        graph.addEgde(4,3,100);
        graph.addEgde(4,1,70);
        graph.addEgde(4,2,150);
        permutate(string, "");
    }
}
