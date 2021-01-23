package Graphs;

import LinkedList.DoublyLinkedListWithTail;

public class CheckCycle {

    public static boolean detectCycle(Graph g){

        int num_of_vertices  = g.vertices;

        boolean[] visited = new boolean[num_of_vertices];
        boolean[] stackFlag = new boolean[num_of_vertices];

        for(int i=0; i < num_of_vertices; i++){
            if(cyclic(g, i, visited, stackFlag)) return true;
        }
        return false;
    }

    private static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {

        //if node is currently in stack, means we have found a cycle
        if (stackFlag[v]) return true;

        //if it is already visited and there is no cycle as it would have been captured above, there is no cycle
        if (visited[v]) return false;

        visited[v] = true;
        stackFlag[v] = true;

        // check adjacency list of the node
        DoublyLinkedListWithTail<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;

        while (temp != null){
            //run cyclic function recursively on each outgoing path
            if(cyclic(g, temp.data, visited, stackFlag)){
                return true;
            }
            temp = temp.nextNode;
        }//end of while
        stackFlag[v] = false;

        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}


