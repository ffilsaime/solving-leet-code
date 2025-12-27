package com.florebencia.filsaime.implement;

import java.util.ArrayList;

public class Graph {
    private int numberOfNodes = 0;

    private ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    public Graph() {
        // remember the index of the array is the value of the actual graph node/vertex
        // in the example they used a hashset
    }

    public void addVertex(int vertex) {
        adjacencyList.add(vertex, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int fromVertex, int toVertex) {
        if (adjacencyList.get(fromVertex) != null){
            adjacencyList.get(fromVertex).add(toVertex);
        }

        if (adjacencyList.get(toVertex) != null){
            adjacencyList.get(toVertex).add(fromVertex);
        }
    }

    public void showConnections() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Vertex/Node " + i + ": ");
            for (Integer edge : adjacencyList.get(i)) {
                System.out.print(edge + " ");
            }
            System.out.print("\n");
        }
    }
}
