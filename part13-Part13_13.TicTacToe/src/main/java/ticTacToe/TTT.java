/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author user
 */
public class TTT {

    private String[][] board = new String[3][3];

    public void generate() {
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                board[i][ii] = " ";
            }
        }
    }
    
    public boolean addBoard(int first, int second, String symbol) {
        if (board[first][second].equals(" ")) {
            board[first][second] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWinRow(String symbol) {

        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int ii = 0; ii < 3; ii++) {
                if (board[ii][i].equals(symbol)) {
                    counter++;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkWinColumn(String symbol){
        return board[0][0].equals(symbol)&& board[1][0].equals(symbol)&&board[2][0].equals(symbol) || 
                board[1][0].equals(symbol)&& board[1][1].equals(symbol)&&board[1][2].equals(symbol) ||
                 board[2][0].equals(symbol)&& board[2][1].equals(symbol)&&board[2][2].equals(symbol);
    }
    
    public boolean checkWinDiagonal(String symbol){
        
        return board[0][0].contains(symbol)&& board[1][1].contains(symbol) && board[2][2].contains(symbol) ||
               board[0][2].contains(symbol)&& board[1][1].contains(symbol) && board[2][0].contains(symbol) ;
    }
    
    public boolean checkWin(String symbol){
        return checkWinDiagonal(symbol) || checkWinColumn(symbol) || checkWinRow(symbol);
    }

}
