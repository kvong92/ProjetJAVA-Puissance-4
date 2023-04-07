package model;

// import java.io.*;
import java.text.ParseException;
// import java.util.ArrayList;
import java.util.regex.Pattern;

public class Player {
    private String name;
    private char symbol;
    private String symbolColor;
    private static final String SEPARATOR = ";";
    // private static final Pattern CSV_PATTERN = Pattern.compile(SEPARATOR);
    private static final String inputPattern = "^(?:(?<=^)[^\s" + SEPARATOR + "]|^\s;)(?:[^" + SEPARATOR
            + "]*[^\s;])?$";

    public static boolean patternMatches(String input, String pattern) {
        return Pattern.compile(pattern).matcher(input).matches();
    }

    public Player(String name, char symbol, String symbolColor) {
        this.name = name;
        this.symbol = symbol;
        this.symbolColor = symbolColor;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getSymbolColor() {
        return this.symbolColor;
    }

    public void setName(String name) throws ParseException {
        if (patternMatches(name, inputPattern)) {
            this.name = name;
        } else {
            throw new ParseException("Format nom invalide", 0);
        }
    }

    public void setSymbol(char symbol) throws ParseException {
        if (patternMatches(name, inputPattern)) {
            this.symbol = symbol;
        } else {
            throw new ParseException("Format symbole invalide (non vide et 1 seul caractère)", 0);
        }
    }

    public void setSymbolColor(String symbolColor) {
        this.symbolColor = symbolColor;
    }

    // public static void savePlayerInfo(Player newPlayer) {
    // ArrayList<Player> players = new ArrayList<>();
    // players.add(newPlayer);

    // String separator = SEPARATOR;
    // try (FileWriter writer = new FileWriter("players.csv")) {
    // for (Player player : players) {
    // writer.append(player.getName()).append(separator)
    // .append(Character.toString(player.getSymbol())).append("\n");
    // }
    // } catch (IOException e) {
    // System.out.println("Erreur lors de l'écriture");
    // }
    // }
}
