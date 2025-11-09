import java.io.*;
import java.net.*;
import java.util.*;

public class Task1 {

    public static void main(String[] args) {

        String link = "https://users.metropolia.fi/~jarkkov/temploki.csv";

        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), "UTF-8")
            );

            // header row gho skip
            reader.readLine();

            double sum = 0;
            int count = 0;
            String line;

            // Read each data row
            while ((line = reader.readLine()) != null) {

                // 1.1.23 ka measurement gho pl lo chin loh
                if (line.startsWith("01.01.2023")) {

                    String[] parts = line.split(";");

                    // parts[1] = UlkoTalo column
                    String tempStr = parts[1].replace(",", ".");
                    double temp = Double.parseDouble(tempStr);

                    sum += temp;
                    count++;
                }
            }

            reader.close();

            if (count > 0) {
                double avg = sum / count;
                System.out.printf("Average temperature on 01.01.2023: %.2f°C%n", avg);
            } else {
                System.out.println("No data found for 01.01.2023");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
