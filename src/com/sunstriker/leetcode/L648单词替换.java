package com.sunstriker.leetcode;

import java.util.List;

public class L648单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for (String s : dictionary) {
            t.insert(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = t.searchPrefix( words[i]);
            if(!prefix.equals("")) words[i] = prefix;
        }
        return String.join(" ",words);
    }

    public class Trie {
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert (String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!node.containsKey(c)) node.put(c, new TrieNode());
                node = node.get(c);
            }
            node.setEnd();
        }

        public String searchPrefix(String text){
            TrieNode  node = root;
            int end = 0;
            boolean valid = false;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if(!node.containsKey(c)) break;
                end++;
                node = node.get(c);
                if(node.isEnd()) {
                    valid = true;
                    break;
                }
            }
            return valid ? text.substring(0,  end) : "";
        }


    }

    public class TrieNode {
        private TrieNode[] children;
        private final int R = 26;
        private boolean isEnd = false;

        public TrieNode (){
            children = new TrieNode[R];
        }

        public boolean containsKey(char c) {
            return children[c-'a'] != null;
        }

        public TrieNode get(char c) {
            return children[c-'a'];
        }

        public void put(char c, TrieNode node) {
            children[c-'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}
