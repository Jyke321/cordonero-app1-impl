package baseline;

public class Item {
    private static int count=0;
    private String description;
    private String dueDate;
    private Boolean completed;

    Item() {
        //create new item
        count = count++;
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
    public void markComplete() {
        //alternates value at held in completed
    }
    public int getCount() {
        return count;
    }
}
