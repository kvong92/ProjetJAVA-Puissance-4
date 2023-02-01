import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class topgame {

    public static void main() throws IOException {
        //create a .csv file that can store the top 10 players who won with the least number of moves and output the top 10 players with the move count
        //create a new file
        File file = new File("top10.csv");
        //create a new file writer
        FileWriter outputfile = new FileWriter(file);
        //output the csv header
        outputfile.write("Player:Move Count");
        //create a list of players
        List<String> players = new ArrayList<>();
        //add players to the list
        players.add("Player 1");
        //create a list of move counts
        List<Integer> moveCounts = new ArrayList<>();
        //add move counts to the list
        moveCounts.add(10);
        //output the player and move count to the csv file
        for (int i = 0; i < players.size(); i++) {
            outputfile.write(players.get(i) + ":" + moveCounts.get(i));
        }
        //close the file writer
        outputfile.close();
        //output the top 10 players and move counts from the csv file, output player in red and move count in blue
        System.out.println("\033[0;31m" + "Player " + "\033[0m" + "\033[0;34m" + "Move Count" + "\033[0m");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\033[0;31m" + players.get(i) + " " + "\033[0m" + "\033[0;34m" + moveCounts.get(i) + "\033[0m");
        }

    }
}
