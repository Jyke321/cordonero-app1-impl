package baseline;

import java.util.List;

public class ToDoList {
    private static int count=0;
    private List<Item> items;
    private String title;
    boolean save;

    ToDoList () {
        count = count++;
        this.items = null;
        this.title = "";
        this.save = true;
    }
    public void editTitle(String newTitle) {
        //edits the title
    }
    public void addItem() {
        //adds a blank item by default if there aren't more than 256 items
    }
    public int getCount() {
        return count;
    }
}
