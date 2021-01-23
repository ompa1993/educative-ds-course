package Graphs;

import LinkedList.DoublyLinkedList;
import LinkedList.DoublyLinkedListWithTail;
import StackAndQueue.Stack;

public class CheckPaths {

    public static boolean checkPath(Graph g, int source, int destination){

        if (source == destination) return true;

        boolean[] visited = new boolean[g.vertices];

        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        boolean pathExists = false;
        while(!stack.isEmpty() && !pathExists){

            int current_node = stack.pop();
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null){
                temp = g.adjacencyList[current_node].headNode;
            }

            while(temp != null){
                if (temp.data == destination){
                    pathExists = true;
                    break;
                }
                if(!visited[temp.data]){
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
            visited[current_node] = true;
        }
        return pathExists;
    }
}
