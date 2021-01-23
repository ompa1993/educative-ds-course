package Trees;

public class binarySearchTreeDemo {

    public static void main(String args[]){
        /*
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

        bsT.printTree(bsT.getRoot());

        Node temp = bsT.search(5);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        }
        else
            System.out.println("\n Not found in Tree !");

        temp = bsT.search(51);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        }
        else
            System.out.println("\n Not found in Tree !");
        */
        binarySearchTree bsT = new binarySearchTree();
        bsT.add(6);
        bsT.add(7);
        bsT.add(8);
        bsT.add(12);
        bsT.add(1);
        bsT.add(15);


        System.out.print("Tree : ");
        bsT.printTree(bsT.getRoot());


        System.out.print("\nDeleting Node 6: ");
        bsT.delete(6, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 15: ");
        bsT.delete(15, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 1: ");
        bsT.delete(1, bsT.getRoot());
        bsT.printTree(bsT.getRoot());
    }

}

