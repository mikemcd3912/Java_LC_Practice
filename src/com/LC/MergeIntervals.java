package com.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
    	Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
    	List<int[]> mergedIntervals = new ArrayList<>();
    	int start=intervals[0][0], end = intervals[0][1];
    	for(int i=1;i<intervals.length;i++) {
    		if(intervals[i][0] <= end) {
    			end = Math.max(intervals[i][1], end);
    		}else{
    			mergedIntervals.add(new int[] {start, end});
    			start = intervals[i][0];
    			end=intervals[i][1];
    		}
    	}
		mergedIntervals.add(new int[] {start, end});
        int[][] ans = new int[mergedIntervals.size()][2];
        for(int i=0;i<mergedIntervals.size();i++){
            ans[i] = mergedIntervals.get(i);
        }
    	return ans;
    }
    
}
