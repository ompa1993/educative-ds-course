package Graphs;

import LinkedList.DoublyLinkedListWithTail;

public class Graph {

    int vertices; //to store total number of vertices in the graph
    DoublyLinkedListWithTail<Integer> adjacencyList[]; //to store an array of linked lists. Each index of the array represents
    //// a vertex of the graph, and the linked list represents the adjacent vertices.

    //Constructor
    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedListWithTail[vertices];

        for (int i=0; i < vertices; i++){
            adjacencyList[i] = new DoublyLinkedListWithTail<>();
        }
    }

    //creates a source and destination vertex and connects them with an edge.
    public void addEdge(int source, int destination){
        if (source < vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
            //for undirected graph
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }

    //method prints the graph (adjacency list).
    void printGraph(){
        System.out.println(">>Adjacency List of Directed Graph<<");

        for (int i=0; i < vertices; i++){

            if(adjacencyList[i] != null){
                System.out.print("|" + i + "| => ");
                DoublyLinkedListWithTail<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while(temp != null){
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");

            }

            else{
                System.out.println("|" + i + "| => "+ "null");
            }
        }

    }



}
