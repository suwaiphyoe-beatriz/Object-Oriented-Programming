package view;

import controller.CurrencyController;
import model.Currency;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {
    private CurrencyController controller = new CurrencyController();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        Label labelAmount = new Label("Amount:");
        TextField amountField = new TextField();

        Label labelFrom = new Label("From Currency:");
        ComboBox<Currency> fromBox = new ComboBox<>();
        fromBox.getItems().addAll(controller.getCurrencies());

        Label labelTo = new Label("To Currency:");
        ComboBox<Currency> toBox = new ComboBox<>();
        toBox.getItems().addAll(controller.getCurrencies());

        Label resultLabel = new Label("Converted Amount:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromBox.getValue();
                Currency to = toBox.getValue();
                if (from == null || to == null) {
                    showAlert("Please select both currencies.");
                    return;
                }
                double converted = controller.convert(amount, from, to);
                resultField.setText(String.format("%.2f", converted));
            } catch (NumberFormatException ex) {
                showAlert("Enter a valid number.");
            }
        });

        root.getChildren().addAll(labelAmount, amountField,
                labelFrom, fromBox,
                labelTo, toBox,
                convertButton,
                resultLabel, resultField);

        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
