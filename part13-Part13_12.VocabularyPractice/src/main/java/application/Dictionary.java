/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author user
 */
public class Dictionary {
    
    private ArrayList<String> words;
    private HashMap<String, String> translation;
    
    public Dictionary(){
        this.words = new ArrayList<>();
        this.translation = new HashMap<>();
        words.add("hakuna");
        this.translation.put("hakuna","matata");
    }
    
    public void add(String word, String translation){
        if(!this.translation.containsKey(word)){
            this.words.add(word);
        }
        this.translation.put(word, translation);
    }
    
    public String get(String word){
        return this.translation.get(word);
    }
    
 public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
    
}
