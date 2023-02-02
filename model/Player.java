package model;
import java.text.ParseException;

public class Player {
    private String name;
    private char symbol;
    private String symbolColor;
    private int score;

    public Player(String nom, char symbol, String symbolColor, int score) {
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

    public char getSymbol() {
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

    public void setSymbol(char symbol) throws ParseException {
        if (symbol != ' ' && symbol != '\t' && symbol != '\n' && symbol != '\r' && symbol != '\f') {
            this.symbol = symbol;
        } else {
            throw new ParseException("Format symbole invalide (non vide et 1 seul caractère)", 0);
        }
    }

    public void setSymbolColor(String symbolColor) {
        this.symbolColor = symbolColor;
    }
}