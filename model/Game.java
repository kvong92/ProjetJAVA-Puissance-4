package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {

  private static Scanner scan = new Scanner(System.in);
  public static final String RESET = "\u001B[0m";
  public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
  public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN

  public static List<List<String>> initBoard() {
    List<List<String>> board = new ArrayList<>(7);

    for (int i = 0; i < 7; i++) {
      List<String> row = new ArrayList<>(6);
      for (int j = 0; j < 6; j++) {
        row.add(" ");
      }
      board.add(row);
    }
    return (board);
  }

  public static void displayBoard(List<List<String>> board) {
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

  public static boolean checkDraw(List<List<String>> board) {
    // int i = 6;
    for (int j = 0; j < 7; j++) {
      if (board.get(j).get(0) == " ") {
        return (false);
      }
    }
    return (true);
  }

  public static boolean checkColumnFull(List<List<String>> board, int column) {
    for (int i = 5; i >= 0; i--) {
      if (board.get(column).get(i) == " ") {
        return (false);
      }
    }
    return (true);
  }

  public static void setWinColor(List<List<String>> board, int j, int i, String symbol, Player player) {
    symbol = RED_BOLD_BRIGHT + player.getSymbol() + RESET;
    board.get(j).set(i, symbol);
  }

  public static boolean checkWin(List<List<String>> board, String symbol, Player player) {
    // Check horizontal : --
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        if (board.get(j).get(i).equals(symbol)
            && board.get(j + 1).get(i).equals(symbol)
            && board.get(j + 2).get(i).equals(symbol)
            && board.get(j + 3).get(i).equals(symbol)) {
          System.out.println(GREEN_BOLD_BRIGHT + "\n   La Partie est terminée !\n" + RESET);
          setWinColor(board, j, i, symbol, player);
          setWinColor(board, j + 1, i, symbol, player);
          setWinColor(board, j + 2, i, symbol, player);
          setWinColor(board, j + 3, i, symbol, player);
          displayBoard(board);
          return (true);
        }
      }
    }
    // Check vertical : |
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.get(i).get(j).equals(symbol)
            && board.get(i).get(j + 1).equals(symbol)
            && board.get(i).get(j + 2).equals(symbol)
            && board.get(i).get(j + 3).equals(symbol)) {
          System.out.println(GREEN_BOLD_BRIGHT + "\n   La Partie est terminée !\n" + RESET);
          setWinColor(board, i, j + 1, symbol, player);
          setWinColor(board, i, j + 2, symbol, player);
          setWinColor(board, i, j + 3, symbol, player);
          setWinColor(board, i, j, symbol, player);
          displayBoard(board);
          return (true);
        }
      }
    }
    // Check diagonal : \
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.get(i).get(j).equals(symbol)
            && board.get(i + 1).get(j + 1).equals(symbol)
            && board.get(i + 2).get(j + 2).equals(symbol)
            && board.get(i + 3).get(j + 3).equals(symbol)) {
          System.out.println(GREEN_BOLD_BRIGHT + "\n   La Partie est terminée !\n" + RESET);
          setWinColor(board, i, j, symbol, player);
          setWinColor(board, i + 1, j + 1, symbol, player);
          setWinColor(board, i + 2, j + 2, symbol, player);
          setWinColor(board, i + 3, j + 3, symbol, player);
          displayBoard(board);
          return (true);
        }
      }
    }
    // Check diagonal : /
    for (int i = 0; i < 4; i++) {
      for (int j = 5; j > 2; j--) {
        if (board.get(i).get(j).equals(symbol)
            && board.get(i + 1).get(j - 1).equals(symbol)
            && board.get(i + 2).get(j - 2).equals(symbol)
            && board.get(i + 3).get(j - 3).equals(symbol)) {
          System.out.println(GREEN_BOLD_BRIGHT + "\n   La Partie est terminée !\n" + RESET);
          setWinColor(board, i, j, symbol, player);
          setWinColor(board, i + 1, j - 1, symbol, player);
          setWinColor(board, i + 2, j - 2, symbol, player);
          setWinColor(board, i + 3, j - 3, symbol, player);
          displayBoard(board);
          return (true);
        }
      }
    }
    return (false);
  }

  public static List<List<String>> updateBoard(List<List<String>> board, int column, Player player) {
    // Loop detect if the column is full or not (6 max)
    for (int i = 5; i >= 0; i--) {
      if (board.get(column).get(i) == " ") {
        String symbolInsert = player.getSymbolColor() + player.getSymbol() + RESET;
        board.get(column).set(i, symbolInsert);
        break;
      }
    }
    return (board);
  }

  public static void playerTurn(Player player, List<List<String>> board) {
    while (true) {
      try {
        int column = 0;
        System.out.println(player.getName() + ", veuillez choisir colonne entre 1 et 7 :");
        column = scan.nextInt();
        if (column >= 0 && column <= 7) {
          column = column - 1;
          if (checkColumnFull(board, column) == false) {
            board = updateBoard(board, column, player);
            break;
          } else {
            System.out.println(RED_BOLD_BRIGHT + "La colonne " + (column + 1) + " est pleine." + RESET);
            throw new InputMismatchException();
          }
        }
      } catch (InputMismatchException e) {
        System.out.println(RED_BOLD_BRIGHT + "Veuillez entrer un nombre entre 1 et 7 : " + RESET);
        scan.nextLine();
      }
    }
  }

  public void startGame(Player player1, Player player2, String gameMode) {
    List<List<String>> board = initBoard();
    displayBoard(board);
    int turn = 0;
    while (true) {
      if (checkWin(board, player1.getSymbolColor() + player1.getSymbol() + RESET, player1)) {
        System.out.println(
            GREEN_BOLD_BRIGHT + "\nJoueur : " + player1.getName() + " a gagné en " + turn + " tours !\n" + RESET);
        player1.setScore(turn);
        break;
      } else {
        if (checkWin(board, player2.getSymbolColor() + player2.getSymbol() + RESET, player2)) {
          System.out.println(
              GREEN_BOLD_BRIGHT + "\nJoueur : " + player2.getName() + " a gagné en " + turn + " tours !\n" + RESET);
          player2.setScore(turn);
          break;
        }
      }
      if (checkDraw(board)) {
        System.out.println(GREEN_BOLD_BRIGHT + "       Match nul !" + RESET);
        break;
      }
      if (turn % 2 == 0) {
        playerTurn(player1, board);
      } else {
        playerTurn(player2, board);
      }
      displayBoard(board);
      turn++;
    }
  }
}
