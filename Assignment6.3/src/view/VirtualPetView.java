package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import controller.PetController;
import model.Pet;
import javafx.animation.AnimationTimer;

public class VirtualPetView extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image petImage;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        Pet pet = new Pet(WIDTH / 2, HEIGHT / 2); // start at center
        controller = new PetController(pet);

        // pet image
        petImage = new Image(getClass().getResourceAsStream("/view/pet.png"), 40, 40, true, true);


        canvas.setOnMouseMoved(event -> controller.setTarget(event.getX(), event.getY()));
        canvas.setOnMouseExited(event -> controller.stop());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
                draw();
            }
        }.start();
    }

    private void draw() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(petImage, controller.getPet().getX() - 20, controller.getPet().getY() - 20);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
