package org.example.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ScoresFilePerformer {
    List<String> linesScores = new ArrayList<>();

    public void writeScores(Integer points) {
        try (FileWriter writer = new FileWriter("/Users/sasha/IdeaProjects/" +
                "ThirdLabJava/src/main/java/org/example/HighScores.txt", true)) {
            String text = points.toString() + " " + (new Date()) + "\n";
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getBestResult() {
        BufferedReader reader;
        List<Integer> scores = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("/Users/sasha/IdeaProjects/" +
                    "ThirdLabJava/src/main/java/org/example/HighScores.txt"));
            String line = reader.readLine();
            linesScores.add(line);
            while (line != null) {
                line = reader.readLine();
                linesScores.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(linesScores);
        for(String item : linesScores) {
            if(item!=null) {
                String[] subScoreString = item.split(" ");
                scores.add(Integer.parseInt(subScoreString[0]));
            }
        }
        return linesScores.get(scores.indexOf(Collections.max(scores))+1);
    }
}
