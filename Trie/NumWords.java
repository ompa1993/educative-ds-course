package Trie;

import java.util.Arrays;

//TrieNode => {TrieNode[] children, boolean isEndWord, int value,
//access root => getRoot()
//markAsLeaf(int val), unMarkAsLeaf()}
class NumWords {
    public static int totalWords(TrieNode root){
        int count = 0;

        if (root.isEndWord){
            count++;
        }

        for(int i =0; i < root.children.length; i++){
            if(root.children[i] != null){
                count = count + totalWords(root.children[i]);
            }
        }
        return count;
    }
    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        int i;
        for (i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        int num = totalWords(t.getRoot());
        System.out.println("Number: " + num);

    }

}