package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Item> list = new ArrayList<>();
    private String view;
    private ObservableList<Item> items = FXCollections.observableList(list);

    public void setViewType(String view) {
        this.view = view;
    }
    public String getViewType() {
        return view;
    }
    public void addItem(Item item) {
        //adds a blank item by default if there aren't more than 100 items
        items.add(item);
    }
    public void editItem(int item, String newDescription, String newDueDate) {
        //edits a predefined item
        items.get(item).editDescription(newDescription);
        items.get(item).editDueDate(newDueDate);
    }
    public int getItemCount() {
        return items.size();
    }
    public String getDescription(int i) {
        return items.get(i).getDescription();
    }
    public String getDueDate(int i) {
        return items.get(i).getDueDate();
    }
    public void clearList() {
        //clears all items from list
        items.clear();
    }
    public ObservableList<Item> getItems() {
        return items;
    }
    public void deleteItem(int item) {
        items.remove(item,item);
    }
    public Boolean getCompleted(int item) {
        return items.get(item).getCompleted();
    }
}
