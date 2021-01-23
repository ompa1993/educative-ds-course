package Trie;

public class Trie {

    public TrieNode getRoot() {
        return root;
    }



    private TrieNode root;

    //constructor
    Trie(){
        root = new TrieNode();
    }

    //function to get the index of character 't'
    public int getIndex(char t){
        return t - 'a';
    }

    //Function to insert a key in the trie
    public void insert(String key){
        if (key == null){
            System.out.println("Null Key can not be Inserted!");
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0; //to store character index

        //Iterates the Trie with given character index
        //if it is null, then simply create a TrieNode and go down a level
        for (int level=0; level < key.length(); level++){
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }

        //Mark the end character as a leaf node
        currentNode.markAsLeaf();
    }

    //Function to search given key in the Trie
    public boolean search(String key){

        if (key == null) return false;

        int index = 0;
        TrieNode currentNode = this.root;
        key = key.toLowerCase();

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traversed the
        //Trie based on the length of the key
        for (int level=0; level < key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if(currentNode == null){
            System.out.println("Key doesn't exist");
            return deletedSelf;
        }
        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)){
                currentNode = null;
                deletedSelf = true;
            }

            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }//end of base case

        else{
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted){
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord){
                    deletedSelf = false;
                }

                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }

                //Else we can delete currentNode
                else{
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    private boolean hasNoChildren(TrieNode currentNode) {
        for(int i=0; i < currentNode.children.length; i++){
            if (currentNode.children[i] != null){
                return false;
            }
        }
        return true;
    }

    //function to delete
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

}
