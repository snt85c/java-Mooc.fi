package smiley;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) throws Exception {

        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        ColorPicker colorPalette = new ColorPicker();
        Button clearButton = new Button("Clear");

        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);
        layout.setRight(colorPalette);
        layout.setLeft(clearButton);

        setSmile(painter);

        paintingCanvas.setOnMouseDragged((event) -> {
            double xLocation = event.getX();
            double yLocation = event.getY();
            painter.setFill(colorPalette.getValue());
            painter.fillOval(xLocation, yLocation, 4, 4);
        });

        clearButton.setOnMouseClicked((click) -> {
            paintingCanvas.getGraphicsContext2D().clearRect(0, 0, stage.getWidth(), stage.getHeight());
        });

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void setSmile(GraphicsContext painter) {

        painter.setFill(Color.BLACK);

        painter.fillRect(70, 60, 25, 25);//left eye
        painter.fillRect(200, 60, 25, 25);//right eye
        painter.fillRect(75, 200, 150, 25); //mouth line
        painter.fillRect(75, 175, 25, 25); //leeft mouth corner
        painter.fillRect(200, 175, 25, 25);//right mouth courner
    }

}
