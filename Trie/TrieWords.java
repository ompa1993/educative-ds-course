package Trie;

import java.util.ArrayList;
import java.util.Arrays;

//TrieNode => {TrieNode[] children, boolean isEndWord, int value,
//access root => getRoot()
//markAsLeaf(int val), unMarkAsLeaf()}
class TrieWords {
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

    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList <String> result, int level, char[] str)
    {
        if(root.isEndWord){
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x=0; x < level; x++){
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }
        for(int i =0; i < root.children.length; i++){
            if(root.children[i] != null){
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }

    public static ArrayList< String > findWords(TrieNode root)
    {
        ArrayList<String> result = new ArrayList<String>();
        char[] str = new char[26];
        getWords(root, result, 0, str);
        // write your code here
        return result;
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

        ArrayList<String> words = findWords(t.getRoot());
        for(String word : words){
            System.out.println(word);
        }


    }

}