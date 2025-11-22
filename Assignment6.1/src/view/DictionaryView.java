package view;
import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        TextField wordField = new TextField();
        wordField.setPromptText("Enter a word");

        Button searchButton = new Button("Search");

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);
        resultArea.setPrefRowCount(3);

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.getChildren().addAll(wordField, searchButton, resultArea);

        searchButton.setOnAction(e -> {
            String word = wordField.getText().trim();
            String result = controller.search(word);
            resultArea.setText(result);
        });

        Scene scene = new Scene(pane, 350, 200);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}



