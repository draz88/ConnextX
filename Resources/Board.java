/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.util.Arrays;

/**
 *
 * @author dexte_000
 */
public class Board {
    
    String  [][] grid;
    int size;
    int winCondition;

    public Board(int size, int winCondition) {
        this.size = size;
        if(winCondition > size){
            this.winCondition = size;
        }else{
            this.winCondition = winCondition;
        }
        grid = new String[size][size];
        int k = 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = " ";
            }
        }
        
    }

    public void printBoard() {
        String result = "";
        for(int i = 0; i < size; i++){
            result += "   "+i;
        }
        result += "\n";
        for(int i = 0; i < size; i++){
            result += i + " ";
            for(int j = 0; j < size; j++){
                if(j == 0){
                    result += " ";
                }
                if(j != size-1){
                    result += grid[i][j] + " | ";
                }else{
                    result += grid[i][j];
                }
            }
            if(i != size-1){
                result += "\n";
                for(int k = 0; k < size; k++){
                    if(k == 0){
                        result += "  ";
                    }
                    if(k != size-1){
                        result += "---+";
                    }else{
                        result += "---";
                    }
                }
                result += "\n";
            }
        }
        result += "\n";
        System.out.println(result);
    }
    
    public boolean placePiece(int row, int col, String player){
        if(row < size && col < size){
            if(grid[row][col].equals(" ")){
                grid[row][col] = player;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean checkForWinner(int row, int col, String player){
        return (checkRows(row, col, player) || checkCols(row, col, player) || checkDiagonal(row, col, player));
    }
    
    public boolean checkRows(int row, int col, String player){
        boolean result = false;
        int inRow = 1;
        boolean forward = true;
        boolean backwards = true;
        for(int i = 1; i <= winCondition; i++){
            //forward
            if((col+i) < size && grid[row][col+i].equals(player) && forward){
                inRow++;
            }else{
                forward = false;
            }
            //backwards
            if((col-i) >= 0 && grid[row][col-i].equals(player) && backwards){
                inRow++;
            }else{
                backwards = false;
            }
            if(inRow == winCondition){
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean checkCols(int row, int col, String player){
        boolean result = false;
        int inCol = 1;
        boolean forward = true;
        boolean backwards = true;
        for(int i = 1; i <= winCondition; i++){
            //down
            if((row+i) < size && grid[row+i][col].equals(player) && forward){
                inCol++;
            }else{
                forward = false;
            }
            //up
            if((row-i) >= 0 && grid[row-i][col].equals(player) && backwards){
                inCol++;
            }else{
                backwards = false;
            }
            if(inCol == winCondition){
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean checkDiagonal(int row, int col, String player){
        boolean result = false;
        int inDiag = 1;
        boolean forwardUp = true;
        boolean forwardDown = true;
        boolean backwardsUp = true;
        boolean backwardsDown = true;
        for(int i = 1; i <= winCondition; i++){
            //count forward and up
            if((row-i) >= 0 && (col+i) < size && grid[row-i][col+i].equals(player) && forwardUp){
                inDiag++;
            }else{
                forwardUp = false;
            }
            //count backwards and down
            if((row+i) < size && (col-i) >= 0 && grid[row+i][col-i].equals(player) && backwardsDown){
                inDiag++;
            }else{
                backwardsDown = false;
            }
            
            if(inDiag == winCondition){
                result = true;
                break;
            }
        }
        if(inDiag != winCondition){
            inDiag = 1;
            for(int i = 1; i <= winCondition; i++){
                //count forward and down
                if((row+i) < size && (col+i) < size && grid[row+i][col+i].equals(player) && forwardDown){
                    inDiag++;
                }else{
                    forwardDown = false;
                }
                //count backwards and up
                if((row-i) >= 0 && (col-i) >= 0 && grid[row-i][col-i].equals(player) && backwardsUp){
                    inDiag++;
                }else{
                    backwardsUp = false;
                }

                if(inDiag == winCondition){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    
    public boolean checkIsBoardFull(){
        boolean result = true;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j] == " "){
                    result = false;
                }
            }
        }
        return result;
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    
    
}
