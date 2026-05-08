package dk.sdu.mmmi.cbse.main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ScoreClient {

    private final String scoreServiceUrl = "http://localhost:8080/score";

    public Long addScore(Long points) {
        try {
            URL url = new URL(scoreServiceUrl + "?point=" + points);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.nextLine();
            scanner.close();
            return Long.parseLong(response);
        } catch (Exception e) {
            return 0L;
        }
    }
}