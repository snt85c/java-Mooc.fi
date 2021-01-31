package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();

        Button button1 = new Button("Joke");
        Button button2 = new Button("Answer");
        Button button3 = new Button("Explanation");
        Button button4 = new Button("Get me out");

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        menu.setAlignment(Pos.CENTER);
        
        HBox bottomMenu = new HBox();
        bottomMenu.setPadding(new Insets(20,20,20,20));
        bottomMenu.setSpacing(10);
        bottomMenu.setAlignment(Pos.CENTER);

        menu.getChildren().addAll(button1, button2, button3);
        layout.setTop(menu);
        
        bottomMenu.getChildren().add(button4);
        layout.setBottom(bottomMenu);
        

        StackPane firstLayout = new StackPane(createView("What do you call a bear with no teeth?"));
        StackPane secondLayout = new StackPane(createView("A gummy bear."));
        StackPane thirdLayout = new StackPane(createView("because, no theet, just gums. get it? me neither."));

        button1.setOnAction((event) -> {
            layout.setCenter(firstLayout);
        });

        button2.setOnAction((event) -> {
            layout.setCenter(secondLayout);
        });

        button3.setOnAction((event) -> {
            layout.setCenter(thirdLayout);
        });
        
        button4.setOnAction((event)->{
            System.exit(0);
        });
        
        layout.setCenter(firstLayout);

        Scene scene = new Scene(layout);
        stage.setTitle("JavaFX swap scene test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
