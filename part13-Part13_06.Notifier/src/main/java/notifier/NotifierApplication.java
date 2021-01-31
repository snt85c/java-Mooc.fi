package notifier;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {
        VBox layoutVB = new VBox();
        TextField textF= new TextField();
        Label label = new Label("");
        Button button1 = new Button("Update");
        button1.setOnAction((event)->{
            label.setText(textF.getText());
            textF.clear();
        });
        
        layoutVB.getChildren().addAll(textF,button1,label);
        
        Scene scene = new Scene(layoutVB);
        window.setScene(scene);
        window.show();
    }

}
