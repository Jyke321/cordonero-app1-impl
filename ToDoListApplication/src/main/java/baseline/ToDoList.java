package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.collections.ObservableList;

public class ToDoList {
    private ObservableList<Item> items;
    ToDoList () {
        this.items = null;
    }
    public void addItem(Item item) {
        //adds a blank item by default if there aren't more than 100 items
    }
    public void editItem(int item) {
        //edits a predefined item
    }
    public int getItemCount() {
        return items.size();
    }
    public void clearList() {
        //clears all items from list
    }
}
