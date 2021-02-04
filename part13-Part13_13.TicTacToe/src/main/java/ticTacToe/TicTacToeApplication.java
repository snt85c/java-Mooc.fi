package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private static String currentSign = "X";

    static String changeCurrentSignFrom(String toBeChanged) {
        if (toBeChanged.equals("X")) {
            currentSign = "O";
            return currentSign;
        } else {
            currentSign = "X";
            return currentSign;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private TTT ttt;

    @Override
    public void init() {
        this.ttt = new TTT();
        ttt.generate();
    }

    @Override
    public void start(Stage stage) {

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        Label text1 = new Label("Turn: " + currentSign);
        text1.setAlignment(Pos.CENTER);
        text1.setFont(Font.font("Monospaced", 40));
        layout.setTop(text1);
        
        
        GridPane board = new GridPane();
        board.setPadding(new Insets(10, 10, 10, 10));
        layout.setCenter(board);


        Button f1 = new Button();
        f1.setMinWidth(80);
        f1.setFont(Font.font("Monospaced", 40));
        f1.setOnAction((event) -> {
            if (ttt.addBoard(0, 0, currentSign)) {
                f1.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });

        Button f2 = new Button();
        f2.setMinWidth(80);
        f2.setFont(Font.font("Monospaced", 40));
        f2.setOnAction((event) -> {
            if (ttt.addBoard(0, 1, currentSign)) {
                f2.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });

        Button f3 = new Button();
        f3.setMinWidth(80);
        f3.setFont(Font.font("Monospaced", 40));
        f3.setOnAction((event) -> {
            if (ttt.addBoard(0, 2, currentSign)) { 
                f3.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });

        Button c1 = new Button();
        c1.setMinWidth(80);
        c1.setFont(Font.font("Monospaced", 40));
        c1.setOnAction((event) -> {
            if (ttt.addBoard(1, 0, currentSign)) {
                c1.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });
        Button c2 = new Button();
        c2.setMinWidth(80);
        c2.setFont(Font.font("Monospaced", 40));
        c2.setOnAction((event) -> {
            if (ttt.addBoard(1, 1, currentSign)) {
                c2.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });
        Button c3 = new Button();
        c3.setMinWidth(80);
        c3.setFont(Font.font("Monospaced", 40));
        c3.setOnAction((event) -> {
            if (ttt.addBoard(1, 2, currentSign)) {
                c3.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                } else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });
        Button l1 = new Button();
        l1.setMinWidth(80);
        l1.setFont(Font.font("Monospaced", 40));
        l1.setOnAction((event) -> {
            if (ttt.addBoard(2, 0, currentSign)) {
                l1.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });
        Button l2 = new Button();
        l2.setMinWidth(80);
        l2.setFont(Font.font("Monospaced", 40));
        l2.setOnAction((event) -> {
            if (ttt.addBoard(2, 1, currentSign)) {
                l2.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });
        Button l3 = new Button();
        l3.setMinWidth(80);
        l3.setFont(Font.font("Monospaced", 40));
        l3.setOnAction((event) -> {
            if (ttt.addBoard(2, 2, currentSign)) {
                l3.setText(currentSign);
                if(ttt.checkWin(currentSign)){
                    text1.setText("The End");
                }else {
                text1.setText("Turn: " + changeCurrentSignFrom(currentSign));
                }
            }
        });

        board.add(f1, 0, 0);
        board.add(f2, 1, 0);
        board.add(f3, 2, 0);
        board.add(c1, 0, 1);
        board.add(c2, 1, 1);
        board.add(c3, 2, 1);
        board.add(l1, 0, 2);
        board.add(l2, 1, 2);
        board.add(l3, 2, 2);

        Scene scene = new Scene(layout, 280, 300);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();

    }

}
