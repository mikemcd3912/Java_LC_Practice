package com.LC;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		

	}
	
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> indexs = new HashMap<>();
    	for(int i=0;i<nums.length;i++) {
    		if(indexs.containsKey(target-nums[i])) {
    			return new int[] {indexs.get(target-nums[i]), i};
    		}
    		indexs.put(nums[i], i);
    	}
    	return null;
    }

}
