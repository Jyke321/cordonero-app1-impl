package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DataHandler {
    private String buffer;
    public ToDoList list = new ToDoList();
    private File saveDirectory;

    public void setViewType(String view) {
        list.setViewType(view);
    }
    public String getViewType() {
        return list.getViewType();
    }

    public void save(File file, File saveFile) throws IOException {
        saveDirectory = saveFile;
        //call toParse()
        toParse();
        //save the data in buffer to the desired file
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath())) {
            fileWriter.write(buffer);
        }
    }
    public void load(File file) {
        //put data in buffer from desired file location
        StringBuilder stringBuffer = new StringBuilder();
        try (Scanner in = new Scanner(new FileReader(file))) {
            while(in.hasNext()) {
                stringBuffer.append(in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        buffer = String.valueOf(stringBuffer);
        //call fromParse()
        fromParse();
    }
    private void toParse() {
        //parse the data and store it in buffer
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(saveDirectory.toString());
        stringBuffer.append("\n");
        stringBuffer.append(list.getItemCount());
        for (int i = 0; i < list.getItemCount(); i++) {
            stringBuffer.append("\n");
            stringBuffer.append(list.getDescription(i));
            stringBuffer.append("\n");
            stringBuffer.append(list.getDueDate(i));
            stringBuffer.append("\n");
            stringBuffer.append(list.getCompleted(i));
        }
        stringBuffer.append("\n");
        stringBuffer.append(list.getViewType());
        stringBuffer.append("\n");
        buffer = String.valueOf(stringBuffer);
    }
    private void fromParse() {
        //un-parse buffer data into the data structures
        List<String> lines = buffer.lines().toList();
        int i = 0;
        saveDirectory = new File(lines.get(i));
        i++;
        int itemCount = Integer.parseInt(lines.get(i));
        list.clearList();
        for (i+=1; i < itemCount; i+=3) {
            Item item = new Item();
            item.editDescription(lines.get(i));
            item.editDueDate(lines.get(i+1));
            item.setCompleted(Boolean.parseBoolean(lines.get(i+2)));
        }
        setViewType(lines.get(i));
    }
}
