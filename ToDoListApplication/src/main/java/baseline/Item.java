package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import java.text.Format;

public class Item {
    private String description;
    private String dueDate;
    private Boolean completed;

    Item() {
        //create new item
        this.description = "";
        this.dueDate = "";
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
        return (newDueDate.isEmpty());
    }
    public void markComplete() {
        //alternates value at held in completed
        completed = !completed;
    }
}
