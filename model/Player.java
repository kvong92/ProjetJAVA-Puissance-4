package model;
import java.text.ParseException;

public class Player {
    private String name;
    private String symbol;
    private String symbolColor;
    private int score;

    public Player(String nom, String symbol, String symbolColor, int score) {
        this.name = nom;
        this.symbol = symbol;
        this.symbolColor = symbolColor;
        this.score = score;
    }

    public Player() {
    }

    public String getNom() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolColor() {
        return this.symbolColor;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) throws ParseException {
        if (name.length() != 0) {
            this.name = name;
        } else {
            throw new ParseException("Format nom invalide", 0);
        }
    }

    // public void setSymbol(String symbol) {
    //     if (symbol.length() > 1) {
    //         System.out.println("Le symbole doit être un seul caractère");
    //         return;
    //     } else if (symbol.length() == 0) {
    //         System.out.println("Le symbole ne peut pas être vide");
    //         return;
    //     }
    //     this.symbol = symbol;
    // }


    public void setSymbol(String symbol) throws ParseException {
        if (symbol.length() == 1 && symbol.length() != 0) {
            this.symbol = symbol;
        } else {
            throw new ParseException("Format symbole invalide (non vide et 1 seul caractère)", 0);
        }
    }

    public void setSymbolColor(String symbolColor) {
        this.symbolColor = symbolColor;
    }
}
