package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/currency_converter";
        String user = "appuser";
        String password = "password";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected successfully!\n");

            //all currencies
            System.out.println("All currencies:");
            ResultSet rsAll = stmt.executeQuery("SELECT * FROM Currency");
            while (rsAll.next()) {
                System.out.printf("%d: %s (%s) = %.6f%n",
                        rsAll.getInt("id"),
                        rsAll.getString("name"),
                        rsAll.getString("abbreviation"),
                        rsAll.getDouble("exchange_rate"));
            }

            //currency with abbreviation EUR
            System.out.println("\nCurrency with abbreviation EUR:");
            ResultSet rsEUR = stmt.executeQuery("SELECT * FROM Currency WHERE abbreviation = 'EUR'");
            if (rsEUR.next()) {
                System.out.printf("%s (%s) = %.6f%n",
                        rsEUR.getString("name"),
                        rsEUR.getString("abbreviation"),
                        rsEUR.getDouble("exchange_rate"));
            }

            // number of currencies
            System.out.println("\nNumber of currencies:");
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) AS total_currencies FROM Currency");
            if (rsCount.next()) {
                System.out.println("Total currencies: " + rsCount.getInt("total_currencies"));
            }

            // currency with  highest exchange rate
            System.out.println("\nCurrency with the highest exchange rate:");
            ResultSet rsMax = stmt.executeQuery("SELECT * FROM Currency ORDER BY exchange_rate DESC LIMIT 1");
            if (rsMax.next()) {
                System.out.printf("%s (%s) = %.6f%n",
                        rsMax.getString("name"),
                        rsMax.getString("abbreviation"),
                        rsMax.getDouble("exchange_rate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
