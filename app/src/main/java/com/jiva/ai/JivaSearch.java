package com.jiva.ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class JivaSearch {

    public static String search(String query) {
        try {
            String encoded = URLEncoder.encode(query, "UTF-8");

            URL url = new URL(
                    "https://www.google.com/search?q=" + encoded);

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");

                if (result.length() > 5000) {
                    break;
                }
            }

            reader.close();
            connection.disconnect();

            return result.toString();

        } catch (Exception e) {
            return "Search error: " + e.getMessage();
        }
    }
}
