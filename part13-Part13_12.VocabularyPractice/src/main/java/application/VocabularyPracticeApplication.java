package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;
    
    @Override
 public void init() throws Exception {

        this.dictionary = new Dictionary();
    }


    @Override
    public void start(Stage stage) {
        
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        Button button1 = new Button("Enter new Words");
        Button button2 = new Button("Practice");
        
        menu.getChildren().addAll(button1, button2);
        layout.setTop(menu);
        
        button1.setOnAction((event)->{
            layout.setCenter(inputView.getView());
        });
        
        button2.setOnAction((event)->{
            layout.setCenter(practiceView.getView());
        });
        
        Scene scene = new Scene(layout,400,300);
        stage.setTitle("dictionary translator");
        stage.setScene(scene);
        stage.show();
        
    }
    
        public static void main(String[] args) {
        launch(args);
    }
}
