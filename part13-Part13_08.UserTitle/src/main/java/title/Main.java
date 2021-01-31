package title;
import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        String title = "";
        Scanner scan = new Scanner(System.in);
        System.out.print(">: ");
        title = scan.nextLine();
        Application.launch(UserTitle.class,"--organization="+title);
        System.out.println("Hello world!");

    }

}
