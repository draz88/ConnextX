/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import Resources.*;
import java.util.*;
/**
 *
 * @author dexte_000
 */
public class MainGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        Player playerX;
        Player playerO;
        
        System.out.println("[Would you like to play a game?]");
        
        //Create players
        System.out.print("[Is player X human? (y/n)] ");
        if(sc.next().equals("n")){
            playerX = new Computer("ComputerX","X");
        }else{
            System.out.print("Player X name: ");
            playerX = new Human(sc.next(),"X");
        }
        System.out.print("[Is player O human? (y/n)] ");
        if(sc.next().equals("n")){
            playerO = new Computer("ComputerO","O");
        }else{
            System.out.print("Player O name: ");
            playerO = new Human(sc.next(),"O");
        }
        
        while(run){
            //get input from user, create and print board
            System.out.print("Board size: ");
            int size = sc.nextInt();
            System.out.print("Connect how many to win: ");
            int winCondition = sc.nextInt();
            Board gameBoard = new Board(size, winCondition);
            gameBoard.printBoard();

            //Game round, X starts
            boolean win = false;
            boolean draw = false;
            boolean piecePlaced;
            String currentPlayer = "X";
            String currentPlayerName = "";
            Coordinates cords;

            //If there is no winner and board is not full, play a round
            while(win == false && draw == false){
                //Get player name and input for placing his/her piece
                if(currentPlayer.equals("X")){
                    currentPlayerName = playerX.getName();
                    cords = playerX.placePiece(gameBoard.getSize());
                }else{
                    currentPlayerName = playerO.getName();
                    cords = playerO.placePiece(gameBoard.getSize());
                }

                //Place piece, if not occupied
                piecePlaced = gameBoard.placePiece(cords.getX(), cords.getY(), currentPlayer);
                if(piecePlaced){
                    //Print board
                    gameBoard.printBoard();

                    //Check if current player has won
                    win = gameBoard.checkForWinner(cords.getX(), cords.getY(), currentPlayer);

                    //If no winner, switch player
                    if(win == false){
                        if(currentPlayer.equals("X")){
                            currentPlayer = "O";
                        }else{
                            currentPlayer = "X";
                        }
                    }
                }else{
                    if((currentPlayer.equals("X") && playerX instanceof Human) || (currentPlayer.equals("O") && playerO instanceof Human)){
                        System.out.println("You can not place a piece there.");
                    }
                }

                //Check if board is full
                draw = gameBoard.checkIsBoardFull();
            }

            //If there is a winner, give points
            if(win){
                if(currentPlayer.equals("X")){
                    playerX.addScore(1);
                }else{
                    playerO.addScore(1);
                }
                //Print out who won and current score
                System.out.println("[Congratulations " + currentPlayerName + " you have won the round.]\n"
                        + "[" + playerX.getName() + " have " + playerX.getScore() + " points.]\n"
                        + "[" + playerO.getName() + " have " + playerO.getScore() + " points.]");
            }else if(draw){ //If there is a draw
                System.out.println("[Board is full, its a draw.]");
            }
            
            //Check if players want to play againg
            System.out.print("\n[Play again? (y/n)] ");
            String playAgain;
            playAgain = sc.next();
            if(playAgain.equals("n")){
                run = false;
                System.out.println("[Final result]\n"
                        + "[" + playerX.getName() + " got " + playerX.getScore() + " points.]\n"
                        + "[" + playerO.getName() + " got " + playerO.getScore() + " points.]");
            }
        }
    }
    
}
