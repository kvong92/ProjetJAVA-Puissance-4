package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static List<List<Character>> initBoard() {
        List<List<Character>> board = new ArrayList<>(7);
    
        for (int i = 0; i < 7; i++) {
          List<Character> row = new ArrayList<>(6);
          for (int j = 0; j < 6; j++) {
            row.add(' ');
          }
          board.add(row);
        }
        return (board);
      }  
      
      public static void displayBoard(List<List<Character>> board) {
        System.out.println("  1   2   3   4   5   6   7");
        for (int i = 0; i < 6; i++) {
          System.out.print("|");
          for (int j = 0; j < 7; j++) {
            System.out.print(" " + board.get(j).get(i) + " |");
          }
          System.out.println();
          System.out.println("|---+---+---+---+---+---+---|");
        }
        System.out.println("\\===========================/");
      }

      public static List<List<Character>> updateBoard(List<List<Character>> board) {
        
        return (board);
      }

      public static void main(String[] args) {
        List<List<Character>> board = initBoard();
        displayBoard(board);
      }
}
