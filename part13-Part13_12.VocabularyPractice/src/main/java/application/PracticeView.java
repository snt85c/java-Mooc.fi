/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author user
 */
public class PracticeView {
    
    Dictionary dictionary;
    String word;
    
    public PracticeView(Dictionary passedDictionary){
        this.dictionary = passedDictionary;
        this.word = dictionary.getRandomWord();
    }
    
    public Parent getView(){
        
        GridPane layout = new GridPane();
        Label l1 = new Label("Translate the word: '"+ this.word + "'");
        TextField tf1 = new TextField();
        Button button1 = new Button("Check");
        Label feedback = new Label("");
        
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10,10,10,10));
        
        layout.add(l1, 0, 0);
        layout.add(tf1, 0, 1);
        layout.add(button1, 0, 2);
        layout.add(feedback, 0,3);
        
        button1.setOnMouseClicked((event)->{
            if(!tf1.getText().isEmpty()){
                String result = tf1.getText();
                if(dictionary.get(word).equals(result)){
                    feedback.setText("Correct!");
                } else {
                    feedback.setText("Incorrect: the translation for the word " + this.word +" is "+ dictionary.get(word)+".");
                    return;
                }
            }
             this.word = dictionary.getRandomWord();
            l1.setText("Translate the word '" + this.word + "'");
            tf1.clear();
        });
        return layout;
    }
    
}
