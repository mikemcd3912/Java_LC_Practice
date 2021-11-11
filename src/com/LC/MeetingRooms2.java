package com.LC;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
    	Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    	PriorityQueue<Integer> rooms = new PriorityQueue<>(intervals.length, (a,b)-> a-b);
    	rooms.add(intervals[0][1]);
    	for(int i=1;i<intervals.length;i++) {
    		if(intervals[i][0] >= rooms.peek()) {
    			rooms.poll();
    		}
    		rooms.add(intervals[i][1]);
    	}
    	return rooms.size();
    	
    }
}
