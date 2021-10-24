package baseline;

import java.util.LinkedList;

public class DataHandler {
    private String buffer;
    public LinkedList<ToDoList> data = new LinkedList<>();

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
}
