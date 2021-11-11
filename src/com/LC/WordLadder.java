package com.LC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	Queue<String> queue = new LinkedList<>();
    	Set<String> words = new HashSet<>(wordList);
    	words.remove(beginWord);
    	queue.add(beginWord);
    	int level =0;
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		level++;
    		for(int i=0;i<size;i++) {
    			String currentWord = queue.poll();
    			if(currentWord.equals(endWord)) return level;
    			List<String> neighbors = neighbors(currentWord);
    			for(String next : neighbors) {
    				if(words.contains(next)) {
    					words.remove(next);
    					queue.add(next);
    				}
    			}
    		}
    	}
    	return 0;
    }
    
    private List<String> neighbors(String word){
    	char[] chars = word.toCharArray();
    	List<String> result = new ArrayList<>();
    	for(int i=0;i<chars.length;i++) {
    		char temp = chars[i];
    		for(char c = 'a'; c<='z'; c++) {
    			chars[i]=c;
    			String neighbor = new String(chars);
    			result.add(neighbor);
    		}
    		chars[i]=temp;
    	}
    	return result;
    }
}
