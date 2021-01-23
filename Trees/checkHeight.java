package Trees;

public class checkHeight {
    public static int findHeight(Node root) {
        //Base case, leaf nodes have 0 height
        if (root == null) return -1;
        else {
            return 1 + Math.max(findHeight(root.getLeftChild()),findHeight(root.getRightChild()));
            // Find Height of left subtree right subtree
            // Return greater height value of left or right subtree (plus 1)
        }
    }

    public static void main(String args[]) {

        binarySearchTree bsT = new binarySearchTree();


        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);

        System.out.println(findHeight(bsT.getRoot()));

    }
}
