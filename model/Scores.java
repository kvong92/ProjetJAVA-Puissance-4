package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scores {
    // Write score to file
    public static void writeScore(String playerName, int score) {
        String fileName = "scores.csv";

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.append("Player Name : ");
            fileWriter.append(playerName);
            fileWriter.append(" | Score : ");
            fileWriter.append(String.valueOf(score));
            fileWriter.append("\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture sur le fichier : " + fileName);
            e.printStackTrace();
        }
    }

    // Read scores from file and print top 10
    public static void showTop10() {
        String fileName = "scores.csv";
        List<PlayerScore> scores = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String playerName = parts[0].substring(14).trim();
                String PlayerScoreString = parts[1].replaceAll("\\D+", ""); // extract numeric value using regex
                int score = Integer.parseInt(PlayerScoreString);
                scores.add(new PlayerScore(playerName, score));
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + fileName);
            e.printStackTrace();
        }
    
        // Sort scores
        Collections.sort(scores);
    
        // Print top 10 scores
        System.out.println("Top 10 Scores:");
        System.out.println(" Player (Score) ");
        for (int i = 0; i < Math.min(scores.size(), 10); i++) {
            PlayerScore score = scores.get(i);
            System.out.println((i + 1) + ". " + score.getPlayerName() + " (" + score.getScore() + ")");
        }
    }
    
    

}