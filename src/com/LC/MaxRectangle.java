package com.LC;

public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
            }
            maxArea = Math.max(maxArea, maxFromHistogram(dp));
        }
        return maxArea;
    }
    
    public int maxFromHistogram(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int  maxArea = 0;
        stack.push(-1);
        
        for(int i=0;i<heights.length; i++){
            while(stack.peek()!=-1 && heights[stack.peek()] >= heights[i]){
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i-stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while(stack.peek()!=-1){
             maxArea =Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxArea;
    }
}
