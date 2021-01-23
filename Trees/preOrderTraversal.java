package Trees;

public class preOrderTraversal {

    public static void preTraverse(Node root){

        if (root == null) return;

        System.out.print(root.getData() + ", ");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());
    }

    public static void main(String[] args) {

        binarySearchTree BST = new binarySearchTree();

        BST.add(6);
        BST.add(4);
        BST.add(2);
        BST.add(5);
        BST.add(9);
        BST.add(8);
        BST.add(12);

        preOrderTraversal.preTraverse(BST.getRoot());

    }
}
