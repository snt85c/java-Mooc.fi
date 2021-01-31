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
public class InputView {
    
    private Dictionary dictionary;
    
    public InputView(Dictionary passedDictionary){
        this.dictionary = passedDictionary;
    }
    
    public Parent getView(){
        
        GridPane layout = new GridPane();
        Label l1 = new Label("Word");
        TextField tf1 = new TextField();
        Label l2 = new Label("Translation");
        TextField tf2 = new TextField();
        Button button1 = new Button("Add to dictionary");
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));
        
        layout.add(l1, 0, 0);
        layout.add(tf1,0,1);
        layout.add(l2,0,2);
        layout.add(tf2,0,3);
        layout.add(button1,0,4);
        
        button1.setOnMouseClicked((event)->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()){
                String word = tf1.getText();
                String translation = tf2.getText();
                dictionary.add(word, translation);
                tf1.clear();
                tf2.clear();
            }
        });
                
        return layout;
    }
    
}
