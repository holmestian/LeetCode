package edu.sjtu.holmes.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by holmes on 16/4/4.
 */
public class WordDictionary {
    private TrieNode root = new TrieNode(0);
    private int total = 0;

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word != null){
            TrieNode current = root;
            int index;
            for(int i=0; i<word.length(); i++){
                index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                    current.children[index] = new TrieNode(++total);
                current = current.children[index];
            }
            current.isWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null) return false;
        LinkedList<TrieNode> stack = new LinkedList<>();
        boolean[] flags = new boolean[total+1];
        Arrays.fill(flags,false);
        int index = 0;
        TrieNode current;

        stack.push(root);
        flags[root.number]=true;
        while(stack.size() != 0){
            current = stack.peek();
            if(word.charAt(index) == '.'){
                TrieNode next = null;
                for(int i=0; i<26; i++){
                    if(current.children[i]!=null && !flags[current.children[i].number]){
                        next = current.children[i];
                        break;
                    }
                }
                current = next;
            }else{
                current = current.children[word.charAt(index)-'a'];
            }
            if(current == null || flags[current.number] || index==word.length()-1 && !current.isWord){
                stack.pop();
                index--;
            }else{
                if(index == word.length()-1)
                    return true;
                flags[current.number] = true;
                stack.push(current);
                index++;
            }
        }
        return false;
    }

    private static class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
        public int number;

        public TrieNode(int number){
            this.number = number;
        }
    }

    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("add");
        wordDictionary.addWord("adds");

        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("."));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");