/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;
import java.util.*;
import java.lang.*;

/**
 *
 * @author dexte_000
 */
public class Player {
    String name;
    int score;
    String piece;

    public Player(String name, String piece){
        this.name = name;
        this.score = 0;
        this.piece = piece;
    }
    
    public void addScore(int score){
        this.score += score;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public String getName(){
        return this.name;
    }
    
    
    public Coordinates placePiece(int size){
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ", place your " + piece);
        System.out.print("Row: ");
        int row = sc.nextInt();
        System.out.print("Column: ");
        int col = sc.nextInt();
        Coordinates cords = new Coordinates(row, col);
        return cords;
    }
    
}
