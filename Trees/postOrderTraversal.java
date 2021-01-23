package Trees;

public class postOrderTraversal {

    public static void postTraverse(Node root){
        if (root == null){
            return;
        }

        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.print(root.getData() + ", ");
    }
}
