package com.LC;

import java.util.HashMap;

public class PermutationInString {
	HashMap<Character, Integer> s1occurances;
	
	public boolean checkInclusion(String s1, String s2) {
	        
	    char[] charsS1 = s1.toCharArray();
	    char[] charsS2 = s2.toCharArray();
	    s1occurances = new HashMap<>();
	    for(char letter : charsS1) {
	    	s1occurances.put(letter, s1occurances.getOrDefault(letter, 0) +1);
	    }
	    for(int i=0;i<s2.length();i++) {
	    	if(checkSubArray(i, charsS1, charsS2)) {
	    		return true;
	    	}
	    }
	    return false;
    }
    
    private boolean checkSubArray(int startIndex, char[] s1, char[] s2) {
    	HashMap<Character, Integer> s2occurances = new HashMap<>();
	    for(int i=startIndex; i<startIndex+s1.length; i++) {
	    	if(i>= s2.length) {
	    		return false;
	    	}
	    	s2occurances.put(s2[i], s2occurances.getOrDefault(s2[i], 0) +1);
	    }
        System.out.println(s2occurances);
        System.out.println(s1occurances);
	    return s2occurances.equals(s1occurances);
    }
}
