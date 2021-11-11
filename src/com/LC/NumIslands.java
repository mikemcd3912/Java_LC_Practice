package com.LC;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
    	for(int y=0;y<grid.length;y++) {
        	for(int x=0;x<grid[0].length; x++) {
        		if(grid[y][x] == '1') {
        			islands++;
        			dfs(grid, x, y);
        		}
        	}
        }
    	
    	return islands;
    }
    
    private void dfs(char[][] grid, int x, int y) {
    	if(x<0 || y<0 || x>=grid[0].length || y>=grid.length || grid[y][x] == '0') {
    		return;
    	}else {
    		grid[y][x] = '0';
    		dfs(grid, x+1, y);
    		dfs(grid, x-1, y);
    		dfs(grid, x, y+1);
    		dfs(grid, x, y-1);
    	}
    }
}
