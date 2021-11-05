package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

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
    }
    public String getDescription() {
        //gets the description and returns it
        return "";
    }
    public void editDueDate(String newDueDate) {
        //sets the due date to the new one
    }
    public String getDueDate() {
        //gets the due date and returns it
        return "";
    }
    public boolean validateDescription(String newDescription) {
        //validate description
        return false;
    }
    public boolean validateDueDate(String newDescription) {
        //validate due date
        return false;
    }
    public void markComplete() {
        //alternates value at held in completed
    }
}
