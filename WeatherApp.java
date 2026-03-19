import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class WeatherApp {

    public static void main(String[] args) {
        try {
            String city = "Delhi";
            String apiKey = "b1eaca8adae384338e39ddad952c58dd";

            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

            System.out.println("URL: " + urlString); // debug

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader;

            if (responseCode == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
            } else {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream()));
            }

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String json = response.toString();
            System.out.println("Response: " + json); // debug

            if (responseCode != 200) {
                System.out.println("API Error. Check your API key.");
                return;
            }

            // Extract data
            String temp = json.split("\"temp\":")[1].split(",")[0];
            String weather = json.split("\"description\":\"")[1].split("\"")[0];

            System.out.println("City: " + city);
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Weather: " + weather);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}