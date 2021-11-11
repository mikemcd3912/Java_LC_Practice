package com.LC;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == letters[0]){
                    if(search(letters, board, row, col, 0)){
                        return true;
                    }    
                }
            }
        }
        return false;
    }
    
    public boolean search(char[] letters, char[][] board, int row, int col, int index){
        if(index == letters.length-1 && board[row][col] == letters[index]){
            return true;
        }else if(board[row][col] == letters[index]){
            index++;
            char temp = board[row][col];
            board[row][col] = '#';
            boolean ans = false;
            if(row+1 < board.length) ans  = ans || search(letters, board, row+1, col, index);
            if(row-1 >= 0) ans = ans ||search(letters, board, row-1, col, index);
            if(col+1 < board[0].length) ans = ans || search(letters, board, row, col+1, index);
            if(col-1 >=0) ans = ans || search(letters, board, row, col-1, index);
            board[row][col] = temp;
            return ans;
        }
        return false;
    }
}
