package LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Main class for running LinkedLists");

        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i=1; i<=5; i++) {
            //sll.insertAtHead(i);
            sll.insertAtEnd(i);
            //sll.printList();
        }
        sll.insertAfter(6, 6);
        sll.printList();
        if(sll.searchNode(6)) System.out.println("Value found in linkedList");
        //sll.printList();
        //sll.deleteAtHead();
        //sll.printList();
        //if (!(sll.searchNode(1))) System.out.println("Value Not found in linkedList");
        //sll.printList();
        sll.deleteNode(3);
        sll.printList();
    }
}
