package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String organization = params.getNamed().get("organization");


        window.setTitle(organization);
        window.show();
    }

}
