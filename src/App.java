package src;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Player;

public class App {
    /** Attribute scan: Scanner to read user input. **/

    private static Scanner scan = new Scanner(System.in);

    /** Color **/

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    /** Display the main menu. **/
    public static void showMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("|--------- Menu ---------|");
        menus.add("1 - Jouer contre l'IA");
        menus.add("2 - Jouer à 2");
        menus.add("3 - Afficher le top 10");
        menus.add("q - Quitter");
        menus.add("Veuillez entrer un choix");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void showColorMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("-- Menu Couleur --");
        menus.add("1 - BLACK");
        menus.add("2 - RED");
        menus.add("3 - GREEN");
        menus.add("4 - YELLOW");
        menus.add("5 - BLUE");
        menus.add("6 - PURPLE");
        menus.add("7 - CYAN");
        menus.add("8 - WHITE");
        menus.add("q - Quitter");
        menus.add("Veuillez entrer un choix");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static Player createPlayer() throws ParseException {
        Player newPlayer = new Player();
        System.out.println("Entrez votre nom : ");
        String name = scan.nextLine();
        newPlayer.setName(name);
        System.out.println("Entrez votre symbole : ");
        String symbol = scan.nextLine();
        newPlayer.setSymbol(symbol);
        while (true) {
            System.out.println("Choississez votre couleur : ");
            showColorMenu();
            String choice = scan.nextLine();
            switch (choice) {
                case "1" -> {
                    newPlayer.setSymbolColor(BLACK);
                }
                case "2" -> {
                    newPlayer.setSymbolColor(RED);
                }
                case "3" -> {
                    newPlayer.setSymbolColor(GREEN);
                }
                case "4" -> {
                    newPlayer.setSymbolColor(YELLOW);
                }
                case "5" -> {
                    newPlayer.setSymbolColor(BLUE);
                }
                case "6" -> {
                    newPlayer.setSymbolColor(PURPLE);
                }
                case "7" -> {
                    newPlayer.setSymbolColor(CYAN);
                }
                case "8" -> {
                    newPlayer.setSymbolColor(WHITE);
                }
                default -> System.out.println("Veuillez choisir une option valable");
            }
            return newPlayer;
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            showMenu();
            String choice = scan.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Player vs Player PlayVsPlayer()");
                    Player NouveauJoueur = createPlayer();
                    System.out.println("Nom : " + NouveauJoueur.getNom());
                    System.out.println("Symbole : " + NouveauJoueur.getSymbol());
                    System.out.println("Couleur : ");
                    System.out.println(NouveauJoueur.getSymbolColor() + "Couleur" + RESET);
                    return;
                }
                case "2" -> {
                    System.out.println("Jouer VS IA PlayVsIa()");
                }
                case "3" -> {
                    System.out.println("Affichage du TOP 10 ShowTop10()");
                }
                case "q" -> {
                    System.out.println("Fermeture de l'application ...");
                    return;
                }
                default -> System.out.println("Veuillez choisir une option valable");
            }
        }
    }
}