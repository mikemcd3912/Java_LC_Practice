package com.LC;

import java.util.PriorityQueue;

public class MedianInStream {

    PriorityQueue<Integer> low = new PriorityQueue<>((a, b)-> b-a);
    PriorityQueue<Integer> high = new PriorityQueue<>();
    int leftSize;
    int rightSize;
    
    public MedianFinder() {
        this.leftSize = 0;
        this.rightSize = 0;
    }
    
    public void addNum(int num) {
        if(leftSize == 0){
            this.leftSize++;
            low.add(num);
        }else if(num <= low.peek()){
            this.leftSize++;
            low.add(num);
        }else if(rightSize == 0){
            this.rightSize++;
            high.add(num);
        }else if(num >= high.peek()){
            this.rightSize++;
            high.add(num);
        }else{
            this.leftSize++;
            low.add(num);
        }
        balance();
    }
    
    public double findMedian() {
        if(this.leftSize == this.rightSize){
            return (low.peek() + high.peek())/2.0;
        }else{
            return low.peek();
        }
    }
    
    private void balance(){
        while(this.leftSize > this.rightSize+1){
            rightSize++;
            leftSize--;
            high.add(low.poll());
            
        }
        while(this.rightSize > this.leftSize){
            rightSize--;
            leftSize++;
            low.add(high.poll());
        }
    }
}
