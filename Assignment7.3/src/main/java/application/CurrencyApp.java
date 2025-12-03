package application;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Insets;
import java.util.List;

public class CurrencyApp extends Application {

    private CurrencyDao currencyDao = new CurrencyDao();
    private ComboBox<Currency> cbFrom;
    private ComboBox<Currency> cbTo;
    private TextField tfAmount;
    private Label lblResult;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter (JPA)");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        cbFrom = new ComboBox<>();
        cbTo = new ComboBox<>();
        tfAmount = new TextField();
        lblResult = new Label();
        Button btnConvert = new Button("Convert");
        Button btnAddCurrency = new Button("Add Currency");

        grid.add(new Label("From:"), 0, 0);
        grid.add(cbFrom, 1, 0);
        grid.add(new Label("To:"), 0, 1);
        grid.add(cbTo, 1, 1);
        grid.add(new Label("Amount:"), 0, 2);
        grid.add(tfAmount, 1, 2);
        grid.add(btnConvert, 1, 3);
        grid.add(lblResult, 1, 4);
        grid.add(btnAddCurrency, 1, 5);

        // Load currencies from DB
        updateCurrencyComboBoxes();

        // Conversion button
        btnConvert.setOnAction(e -> convertCurrency());

        // Add new currency button
        btnAddCurrency.setOnAction(e -> openAddCurrencyWindow());

        primaryStage.setScene(new Scene(grid, 400, 300));
        primaryStage.show();
    }

    private void updateCurrencyComboBoxes() {
        try {
            List<Currency> currencies = currencyDao.findAll();
            cbFrom.getItems().setAll(currencies);
            cbTo.getItems().setAll(currencies);
        } catch (Exception e) {
            showError("Error loading currencies from database: " + e.getMessage());
        }
    }

    private void convertCurrency() {
        try {
            Currency from = cbFrom.getValue();
            Currency to = cbTo.getValue();
            double amount = Double.parseDouble(tfAmount.getText());
            if (from == null || to == null) {
                showError("Please select both currencies.");
                return;
            }
            double result = amount * (to.getRateToUsd() / from.getRateToUsd());
            lblResult.setText(String.format("%.4f %s", result, to.getAbbreviation()));
        } catch (NumberFormatException e) {
            showError("Please enter a valid amount.");
        } catch (Exception e) {
            showError("Conversion error: " + e.getMessage());
        }
    }

    private void openAddCurrencyWindow() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add New Currency");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField tfAbbr = new TextField();
        TextField tfName = new TextField();
        TextField tfRate = new TextField();
        Button btnSave = new Button("Save");

        grid.add(new Label("Abbreviation:"), 0, 0);
        grid.add(tfAbbr, 1, 0);
        grid.add(new Label("Name:"), 0, 1);
        grid.add(tfName, 1, 1);
        grid.add(new Label("Rate to USD:"), 0, 2);
        grid.add(tfRate, 1, 2);
        grid.add(btnSave, 1, 3);

        btnSave.setOnAction(e -> {
            try {
                String abbr = tfAbbr.getText().trim();
                String name = tfName.getText().trim();
                double rate = Double.parseDouble(tfRate.getText().trim());
                Currency currency = new Currency(abbr, name, rate);
                currencyDao.persist(currency);
                stage.close();
                updateCurrencyComboBoxes(); // refresh main UI
            } catch (Exception ex) {
                showError("Error adding currency: " + ex.getMessage());
            }
        });

        stage.setScene(new Scene(grid, 300, 200));
        stage.showAndWait();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
