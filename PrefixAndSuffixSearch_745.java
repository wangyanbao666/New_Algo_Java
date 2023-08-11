package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PrefixAndSuffixSearch_745 {
    class WordFilter {
        private HashMap<String,Integer> map = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i=0;i<words.length;i++){
                String word = words[i];
                for (int k=0;k<word.length();k++){
                    String sub1 = word.substring(0,k+1);
                    for (int j=word.length()-1;j>=0;j--){
                        String sub2 = word.substring(j);
                        String combine = sub1+"|"+sub2;
                        map.put(combine, i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return map.getOrDefault(pref+"|"+suff, -1);
        }
    }

    class Node {
        public int idxs;
        public Node[][] children;

        Node(){
            idxs = -1;
            children = new Node[26][26];
        }
    }

}
