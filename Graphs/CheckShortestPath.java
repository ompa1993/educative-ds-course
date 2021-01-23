package Graphs;

import LinkedList.DoublyLinkedListWithTail;
import StackAndQueue.Queue;

public class CheckShortestPath {

    public static int findShortestPathLength(Graph g, int source, int destination) {

        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[g.vertices];

        Queue<Integer> queue = new Queue<>(num_of_vertices);

        //For keeping track of distance of current_node from source
        int[] distance = new int[num_of_vertices];

        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()){

            int current_node = queue.dequeue();

            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null){
                temp = g.adjacencyList[current_node].headNode;
            }

            while(temp != null){

                if(!visited[temp.data]){
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[current_node] + 1;
                }

                if ( destination == temp.data){
                    return distance[destination];
                }
                temp = temp.nextNode;
            }

        }
        return -1;
    }

    public static void main(String args[]) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(findShortestPathLength(g, 0, 4));
    }
}
