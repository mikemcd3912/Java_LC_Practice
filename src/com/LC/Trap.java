package com.LC;

public class Trap {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for(int i=0;i<len;i++){
            if(i==0){
                leftMax[i] = height[0];
            }else{
                leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            }
        }
        for(int j=len-2;j>=0;j--){
            if(j==0){
                rightMax[j] = height[len-1];
            }else{
                rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
            }
        }
        int caught = 0;
        for(int k=1;k<len-1;k++){
            if(height[k] < leftMax[k] && height[k] < rightMax[k]) {
            	caught+=Math.min(leftMax[k] - height[k], rightMax[k] - height[k]);
            }
        }
        return caught;
    }
}
