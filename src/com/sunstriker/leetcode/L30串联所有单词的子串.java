package com.sunstriker.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class L30串联所有单词的子串 {
    public static void main(String[] args) {
        var s =  "wordgoodgoodgoodbestword";
        var words = new String[]{"word","good","best","good"};
        var l = new L30串联所有单词的子串().findSubstring(s, words);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLength = words[0].length();
        int wordCount = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, List<Integer>> temp = new HashMap<>();
            map.forEach((str, count) -> temp.put(str, new ArrayList<>()));
            int startingIndex = i, currentIndex = i;

            while (startingIndex <= s.length() - wordLength * wordCount) {
                String nextSegment = s.substring(currentIndex, currentIndex+ wordLength);
                if (!map.containsKey(nextSegment)) {
                    // 如果下一段不包含在map内，则直接跳到currentIndex+wordLength
                    for (String s1 : temp.keySet()) {
                        temp.put(s1, new ArrayList<>());
                    }
                    startingIndex = currentIndex + wordLength;
                    currentIndex += wordLength;
                    startingIndex = currentIndex;
                    continue;
                } else {
                    // 若包含 则考虑有没有超出的两种情况
                    List<Integer> occurrences = temp.get(nextSegment);
                    int mapCount = map.get(nextSegment);
                    if (occurrences.size() < mapCount) {
                        // 若未超出
                        occurrences.add(currentIndex);
                        currentIndex += wordLength;
                    } else {
                        // 若词频数量超出，则设置startingIndex为该词频第一次出现的地方后面，并摒弃掉temp中所有多余数据
                        startingIndex = occurrences.get(0) + wordLength;
//                        currentIndex = startingIndex;
                        ClearMapBeforeSmallest(temp, startingIndex);
                    }
                }
                if(currentIndex - startingIndex == wordLength * wordCount){
                    // 此时一致
                    res.add(startingIndex);
                    startingIndex = startingIndex + wordLength;
                    ClearMapBeforeSmallest(temp, startingIndex);
                }

            }
        }
        return res;
    }
    public void ClearMapBeforeSmallest(HashMap<String, List<Integer>> temp, int smallest){
        for (String word : temp.keySet()) {
            List<Integer> list = temp.get(word);
            temp.put(word, list.stream().filter(index -> index >= smallest).collect(Collectors.toList()));
        }
    }
}
