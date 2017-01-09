/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.util.Random;

/**
 *
 * @author dexte_000
 */
public class Computer extends Player{
    //Coordinates lastCords;

    public Computer(String name, String piece) {
        super(name, piece);
    }
    
    @Override
    public Coordinates placePiece(int size){
        int row = randomNumber(0, size-1);
        int col = randomNumber(0, size-1);
        Coordinates cords = new Coordinates(row, col);
        System.out.println("row: "+row+" Col: "+col);
        return cords;
    }
    
    protected int randomNumber(int min, int max){
        Random randomNumber = new Random();
        return randomNumber.nextInt((max-min)+1)+min;
    }
    
}
