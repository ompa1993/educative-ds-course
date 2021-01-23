package LinkedList;

class NthElementChallenge {
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        // Write -- Your -- Code
        if (list.isEmpty()) return null;
        int waitTillIndex = n;

        SinglyLinkedList<T>.Node tmp = list.getHeadNode();
        SinglyLinkedList<T>.Node second = list.getHeadNode();
        while(tmp != null){
            if(waitTillIndex != 0){
                tmp = tmp.nextNode;
                waitTillIndex--;
            }
            else{
                tmp = tmp.nextNode;
                second = second.nextNode;
            }
        }
        if (waitTillIndex != 0 ) return null;
        return second.data;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 10));//will return null
    }
}