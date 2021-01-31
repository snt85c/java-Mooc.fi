package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        BorderPane layout = new BorderPane();
        HBox bottom = new HBox();
        TextArea text1 = new TextArea();
        Label chars = new Label("Letters:");
        Label word = new Label("Words:");
        Label longests = new Label("The longest word is:");
        layout.setCenter(text1);
        layout.setBottom(bottom);
        bottom.setSpacing(20);
        bottom.getChildren().addAll(chars, word, longests);
        text1.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            chars.setText("Letters: " + characters);
            word.setText("Words: " + words);
            longests.setText("The longest word is: " + longest);
        });

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}
