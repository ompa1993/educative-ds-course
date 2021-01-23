package LinkedList;

public class SinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    public SinglyLinkedList(){
        headNode = null;
        size = 0;

    }

    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public void insertAtHead(T data) {

        Node newNode = new Node();
        newNode.data = data;

        newNode.nextNode = headNode;
        headNode = newNode;

        size++;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        if (isEmpty()){
            headNode = newNode;
            return;
        }

        Node iterNode = headNode;
        while(iterNode.nextNode != null) {
            iterNode = iterNode.nextNode;
        }

        iterNode.nextNode = newNode;
        newNode.nextNode = null;
    }

    public void insertAfter(T data, T previous){
        Node newNode = new Node();
        newNode.data = data;

        Node tmp = headNode;
        while(tmp != null && tmp.data != previous){
            tmp = tmp.nextNode;
        }
        if (tmp != null)
        {
            newNode.nextNode = tmp.nextNode;
            tmp.nextNode = newNode;
            size++;

        }
    }

    public boolean searchNode(T data){
        if (isEmpty()){
            return false;
        }
        Node tmp = headNode;
        while(tmp != null && !tmp.data.equals(data)){
            tmp = tmp.nextNode;
        }
        if (tmp != null) return true;
        return false;
    }

    public void deleteAtHead(){
        if (isEmpty()) return;

        headNode = headNode.nextNode;
        size--;

    }

    public void deleteNode(T data){
        if(isEmpty()) return;

        if(!searchNode(data)) return;

        Node curr = headNode;
        Node prev = null;

        while(curr != null && !curr.data.equals(data)){
            prev = curr;
            curr = curr.nextNode;
        }

        prev.nextNode = curr.nextNode;
    }
    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

}
