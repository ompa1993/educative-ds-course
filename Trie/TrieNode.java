package Trie;

public class TrieNode {

    TrieNode[] children;
    boolean isEndWord; //will be true if the node represents the end of word

    static final int ALPHABET_SIZE = 26; //Total number of english alphabets

    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    //function to mark currentNode as a leaf
    public void markAsLeaf(){
        this.isEndWord = true;
    }

    //function to Unmark currentNode as a leaf
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }

}
