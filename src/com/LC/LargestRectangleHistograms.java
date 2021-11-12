package com.LC;

public class LargestRectangleHistograms {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexs   =   new Stack<>();
        indexs.push(-1);
        int n=heights.length;
        int maxArea = 0;
        for(int i=0;i<n;i++){
            while((indexs.peek()!=-1) && heights[indexs.peek()] >= heights[i]){
                int currentHeight = heights[indexs.pop()];
                int currentWidth = i-indexs.peek()-1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            indexs.push(i);
        }
        while(indexs.peek()!=-1){
            int currentHeight = heights[indexs.pop()];
            int currentWidth = n-indexs.peek() -1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
