package Trees;

import java.util.ArrayList;
import java.util.List;

public class CheckKthMax {

    public static int findKthMax(Node root, int k){
        //Perform in-order traversal to get the sorted array. Return array[length - k]

        List<Integer> sortedNumbers = new ArrayList<Integer>();
        sortedNumbers = traverseInOrder(root, sortedNumbers);

        return sortedNumbers.get(sortedNumbers.size() - k);

    }

    private static List<Integer> traverseInOrder(Node root, List<Integer> sortedNumbers) {

        if(root.getLeftChild()!= null) traverseInOrder(root.getLeftChild(), sortedNumbers);
        sortedNumbers.add(root.getData());
        if(root.getRightChild()!= null) traverseInOrder(root.getRightChild(), sortedNumbers);

        return sortedNumbers;
    }

    public static void main(String args[]) {

        binarySearchTree bsT = new binarySearchTree();

        bsT.add(6);

        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMax(bsT.getRoot(),3));
    }
}
