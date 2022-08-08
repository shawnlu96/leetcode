package com.sunstriker.leetcode;


import java.util.ArrayList;

public class L676MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary dict = new L676MagicDictionary().new MagicDictionary();
        dict.buildDict(new String[]{"hello", "hallo"});
        var res = dict.search("hello");
    }

    public class MagicDictionary {

        public TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                TrieNode node = root;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                    node = node.children[c - 'a'];
                    if (i == s.length() - 1) node.isEnd = true;
                }
            }
        }

        public boolean search(String searchWord) {
            return searchFromNode(searchWord, root, true);
        }

        public boolean searchFromNode(String word, TrieNode node, boolean tolerance) {
            char c = word.charAt(0);
            if (word.length() == 1) {
                if (!tolerance) return node.children[c - 'a'] != null && node.children[c - 'a'].isEnd;
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] == null) continue;
                    if (i != c - 'a' && node.children[i].isEnd) return true;
                }
                return false;
            }
            if (!tolerance) {
                return node.children[c - 'a'] != null && searchFromNode(word.substring(1), node.children[c - 'a'], false);
            }
            // if tolerance
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] == null) continue;
                if (c - 'a' != i) {
                    if (searchFromNode(word.substring(1), node.children[i], false)) return true;
                } else {
                    if (searchFromNode(word.substring(1), node.children[c - 'a'], true)) return true;
                }
            }
            return false;

        }

    }

    public class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

    }

}