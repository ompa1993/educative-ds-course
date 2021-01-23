package Trees;

public class checkHeightMy {
    public static int findHeight(Node root) {
        if (root == null) return 0;

        int smallestElemHt = 0;
        int largestElemHt = 0;

        Node temp1 = root;
        Node temp2 = root;

        while(temp1.getLeftChild() != null){
            smallestElemHt++;
            temp1 = temp1.getLeftChild();
        }
        while(temp2.getRightChild() != null){
            largestElemHt++;
            temp2 = temp2.getRightChild();
        }

        if (smallestElemHt >= largestElemHt) return smallestElemHt;
        return largestElemHt;

    }
}
