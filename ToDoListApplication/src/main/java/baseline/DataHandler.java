package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class DataHandler {
    private String buffer;
    public ToDoList list = new ToDoList();
    private final Map<String,Parent> map = new HashMap<>();
    public Scene scene;
    public Stage stage;


    public void save(String File) {
        //call toParse()
        //save the data in buffer to the desired file
    }
    public void load(String Load) {
        //put data in buffer from desired file location
        //call fromParse()
    }
    private void toParse() {
        //parse the data and store it in buffer
    }
    private void fromParse() {
        //un-parse buffer data into the data structures
    }
    public void addToParentMap(String key,Parent root) {
        map.put(key,root);
    }
    public Parent getRootFromParentMap(String key) {
        return map.get(key);
    }
}
