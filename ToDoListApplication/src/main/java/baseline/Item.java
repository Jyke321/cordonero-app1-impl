package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Item {
    private String description;
    private String dueDate;
    private Button editItem;
    private Button deleteItem;
    private boolean completed;
    private CheckBox checkBox;

    Item() {
        //create new item
        this.description = "";
        this.dueDate = "";
        //initialize edit button
        this.editItem = new Button();
        editItem.setText("Edit");
        //initialize delete button
        this.deleteItem = new Button();
        deleteItem.setText("Delete");
        this.completed = false;
    }

    public void editDescription(String newDescription) {
        //sets the description to the new one
        description = newDescription;
    }
    public String getDescription() {
        //gets the description and returns it
        return description;
    }
    public void editDueDate(String newDueDate) {
        //sets the due date to the new one
        dueDate = newDueDate;
    }
    public String getDueDate() {
        //gets the due date and returns it
        return dueDate;
    }
    public boolean validateDescription(String newDescription) {
        //validate description
        return !newDescription.isEmpty() && (newDescription.length()<256);
    }
    public boolean validateDueDate(String newDueDate) {
        //validate due date
        return ((newDueDate.isEmpty()) || newDueDate.matches(".*^[0-9]{4}([- \\/.])(((0[13578]|(10|12))\\1(0[1-9]|[1-2][0-9]|3[0-1]))|(02\\1(0[1-9]|[1-2][0-9]))|((0[469]|11)\\1(0[1-9]|[1-2][0-9]|30)))$.*"));
    }
    public Button getEditItem() {
        return editItem;
    }
    public void setEditItem(Button edit) {
        editItem = edit;
    }
    public Button getDeleteItem() {
        return deleteItem;
    }
    public void setDeleteItem(Button delete) {
        deleteItem = delete;
    }
    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public CheckBox getCheckBox() {
        return checkBox;
    }
    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
