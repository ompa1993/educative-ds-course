package Trees;

public class CheckAncestors {

    public static String findAncestors(Node root, int value){

        StringBuilder result = new StringBuilder();

        while(root != null && root.getData()!= value){

            if(root.getData() > value) {
                result.append(root.getData() + ",");
                root = root.getLeftChild();
            }
            else{
                result.append(root.getData() + ",");
                root = root.getRightChild();
            }
        }
        return result.toString();
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
        bsT.add(10);
        bsT.add(14);

        System.out.println(findAncestors(bsT.getRoot(),5));
    }
}
