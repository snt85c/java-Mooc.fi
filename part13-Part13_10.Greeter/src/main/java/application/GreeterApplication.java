package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) {
        GridPane layout1 = new GridPane();
        StackPane layout2 = new StackPane();

        Label label1 = new Label("Enter yout name and start");
        TextField text1 = new TextField();
        Button start = new Button("Start");
        Label label2 = new Label();

        layout1.add(label1, 0, 0);
        layout1.add(text1, 0, 1);
        layout1.add(start, 0, 2);
        layout1.setPrefSize(300, 180);
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);
        layout1.setPadding(new Insets(20, 20, 20, 20));

        layout2.getChildren().add(label2);
        layout2.setPrefSize(300, 180);
        layout2.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout1);
        Scene scene2 = new Scene(layout2);

        start.setOnAction((event) -> {
            label2.setText("Welcome " + text1.getText() + "!");
            window.setScene(scene2);
            
        });

        window.setScene(scene1);
        window.show();
    }
}
