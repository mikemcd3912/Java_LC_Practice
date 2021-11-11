package com.LC;

public class IsRobotBounded {
	
    public boolean isRobotBounded(String instructions) {
    	int x=0, y=0;
    	int[][] directions = new int[][] {{0,1}, {1,0},{0,-1},{-1,0}};
    	int facing = 0;
    	
    	for(int i=0;i<instructions.length();i++) {
    		char step = instructions.charAt(i);
    		if(step == 'L') {
    			facing = (facing+3)%4;
    		}else if(step == 'R') {
    			facing = (facing+1)%4;
    		}else {
    			x+=directions[facing][0];
    			y+=directions[facing][1];
    		}
    	}
    	return (x==0 && y==0) || facing!= 0;
    }
	
}
