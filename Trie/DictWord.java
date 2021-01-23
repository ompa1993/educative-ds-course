package Trie;

import java.util.Arrays;

public class DictWord {
    public static boolean isFormationPossible(String[] dict,String word){

        if(word.length() < 2 || dict.length < 2) return false;

        Trie trie = new Trie();
        for(int i = 0; i < dict.length; i++){
            trie.insert(dict[i]);
        }

        for(int i=0; i < word.length(); i++){
            //Slice the word into two parts and in each iteration
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());

            if(trie.search(first) && trie.search(second)) return true;
        }
        return false;
    }

    public static void main(String args[]){
        // Input dict (use only 'a' through 'z' and lower case)
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(dict));

        if(isFormationPossible(dict, "helloworld"))
            System.out.println("true");
        else
            System.out.println("false");

    }
}
