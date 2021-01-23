package Trie;

import java.util.Arrays;

class CheckNumWords {
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


    }
}