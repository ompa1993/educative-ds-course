package Graphs;

import LinkedList.DoublyLinkedListWithTail;
import StackAndQueue.Queue;

public class CheckBFS {
    public static String bfs(Graph g){

        String result = "";
        //checking if graph has any vertices
        if (g.vertices < 1){
            return result;
        }

        //boolean array to hold the history of visited nodes (by default everything is false)
        boolean[] visited = new boolean[g.vertices];

        for(int i=0; i<g.vertices; i++){
            //check if node is visited or not; Only work if it is not visited
            if(!visited[i]){
                result = result+ bfsVisit(g, i, visited);
            }
        }

        return result;


    }

    private static String bfsVisit(Graph g, int source, boolean[] visited) {

        String result = "";

        //Create Queue for BFS and enqueue source into it to start with
        Queue<Integer> queue = new Queue<>(g.vertices);
        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()){
            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.dequeue();

            result = result + String.valueOf(current_node);
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null){
                temp = g.adjacencyList[current_node].getHeadNode();
            }
            while (temp != null){

                if(!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //visit the current node
                }
                temp = temp.nextNode;
            }
        }//end of while

        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
