package Trees;

public class binarySearchTree {

    private Node root;

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node recursive_insert(Node currentNode, int value){

        //Base case
        if (currentNode == null){
            return new Node(value);
        }

        if(value < currentNode.getData()){
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        }
        else if(value > currentNode.getData()){
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        }
        else{
            return currentNode;
        }

        return currentNode;
    }


    public Node search(int value){
        if (isEmpty()) return null;

        //return the output of recursive search function
        return recursive_search(this.root, value);
    }

    private Node recursive_search(Node currentNode, int value) {

        //Base case
        if ((currentNode == null) || (currentNode.getData() == value)) return currentNode;

        if (currentNode.getData() > value){
            return recursive_search(currentNode.getLeftChild(), value);
        }
        else{
            return recursive_search(currentNode.getRightChild(), value);
        }
    }

    public boolean add(int value){
        root = recursive_insert(this.root, value);
        return true;
    }

    //Function to check if tree is empty
    public boolean isEmpty(){
        return this.root == null;
    }



    //3 conditions for delete
    //1.node is leaf node.
    //2.node has 1 child.
    //3.node has 2 children.
    boolean delete(int value, Node currentNode){

        if (root == null) return false;

        //We will search the node to be deleted
        Node parent = null; //Node to store parent of the node to be deleted.
        while ((currentNode != null) && currentNode.getData() != value){
            parent = currentNode;
            if (currentNode.getData() > value){
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }
        } //end of while. Now we have the currentNode as the node which is to be deleted and parent contains its parent

        //if we could not find the node, then delete it
        if (currentNode == null){
            return false;
        }

        //Check if node to be deleted is a leaf node, node with a single child or node with two children
        else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            //It is a leaf node, just delete it and adjust parent's correct pointer to null
            //check if it is a root node first
            if (root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            } else if(parent.getData() > currentNode.getData()){
                parent.setLeftChild(null);
                return true;
            } else{
                parent.setRightChild(null);
                return true;
            }
        } //end of case 1 : just leaf node

        else if (currentNode.getRightChild() == null){
            //case 2 : node with a single child; in this case left child
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            } else if (parent.getData() > currentNode.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            } else{
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        } //end of case 2 - A

        else if (currentNode.getLeftChild() == null){
            //case 2 : node with a single child; in this case right child
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            } else if (parent.getData() > currentNode.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            } else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        }// end of case 2 - B

        else {
            //Means node has both children
            //Find the least Value node in in right-subtree of the curentNode
            Node leastNode = findLeastNode(currentNode.getRightChild());

            //store the least value
            int temp = leastNode.getData();

            //remove least node...
            delete(temp, root);

            //set the current node's data to temp
            currentNode.setData(temp);

            return true;
        }

    }

    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;
        while(temp.getLeftChild() != null){
            temp = temp.getLeftChild();
        }
        return temp;
    }

    //Just for the purpose of testing
    public void printTree(Node current){

        if (current == null) return;
        System.out.print(current.getData() + ", ");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }
}
