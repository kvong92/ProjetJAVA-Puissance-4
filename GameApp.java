import java.util.ArrayList;
import java.util.Scanner;




public class GameApp {
    /**
     * Attribute scan: Scanner to read user input.
     */
    private static Scanner scan = new Scanner(System.in);
    /**
     * Display the main menu.
     */
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
    public static void main(String[] args) throws Exception {
        while (true) {
            showMenu();
            String choice = scan.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Jouer VS Joueur PlayVsPlayer()");
                }
                case "2" -> {
                    System.out.println("Jouer VS IA PlayVsIa()");
                }
                case "3" -> {
                    System.out.println("Affichage du TOP 10");
                    //call the topgame class here
                    topgame.main();

                }
                case "q" -> {
                    System.out.println("Fermeture de l'application ...");
                    return ;
                }
                default -> System.out.println("Veuillez choisir une option valable");
            }
        }
    }

}