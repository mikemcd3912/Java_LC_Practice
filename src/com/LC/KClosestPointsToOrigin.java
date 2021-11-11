package com.LC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    class Point{
        int[] coords;
        double distance;
        public Point(int x, int y){
            this.coords = new int[]{x, y};
            this.distance = Math.sqrt(Math.pow((0-x),2) + Math.pow((0-y),2));
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pointQueue = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point a, Point b){
                return Double.compare(a.distance, b.distance);   
            }
        });
        for(int[] point : points){
            pointQueue.add(new Point(point[0], point[1]));
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pointQueue.poll().coords;
        }
        return ans;
    }
}
