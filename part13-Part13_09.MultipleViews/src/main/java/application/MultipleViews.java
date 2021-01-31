package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layoutFirst = new BorderPane();
        VBox layoutSecond = new VBox();
        GridPane layoutThird = new GridPane();
        
        Scene scene1 = new Scene(layoutFirst);
        Scene scene2 = new Scene(layoutSecond);
        Scene scene3 = new Scene(layoutThird);
        
        Button button1 = new Button("to the second view!");
        Button button2 = new Button("to the third view");
        Button button3 = new Button("to the first view");

        button2.setOnAction((event) -> {
            window.setMinHeight(500);
            window.setMinWidth(500);
            window.setScene(scene3);
        });
        button1.setOnAction((event) -> {
            window.setMinHeight(500);
            window.setMinWidth(500);
            window.setScene(scene2);
        });
        
        button3.setOnAction((event)->{
            window.setMinHeight(500);
            window.setMinWidth(500);
            window.setScene(scene1);
            
        });

        layoutFirst.setTop(new Label("First View"));
        layoutFirst.setCenter(button1);
        layoutSecond.getChildren().add(button2);
        layoutSecond.getChildren().add(new Label("second view"));
        layoutThird.add(new Label("third view!"),0,0);
        layoutThird.add(button3, 1, 1);

        window.setScene(scene1);
        window.show();
    }

}
