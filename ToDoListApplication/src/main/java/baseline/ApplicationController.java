package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;

public class ApplicationController {

    private DataHandler data = new DataHandler();

    @FXML
    private Button addItem;

    @FXML
    private ComboBox<String> changeDisplay;

    @FXML
    private TableColumn<Item, Boolean> complete;

    @FXML
    private TableColumn<Item, String> deleteList;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, String> dueDate;

    @FXML
    private TableColumn<Item, String> editList;

    @FXML
    private TableView<Item> listTable;

    @FXML
    private Button loadButton;

    @FXML
    private Label numberOfItems;

    @FXML
    private Button saveButton;

    @FXML
    void addItem(ActionEvent event) {
        try {
            switchToAddScene(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clearItems() {
        data.list.clearList();
    }

    FileChooser fileChooser = new FileChooser();

    @FXML
    void load(ActionEvent event) {
        Window stage = ((Node)event.getSource()).getScene().getWindow();
        fileChooser.setTitle("Load Dialog");

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));

        try {
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            data.load(file);
        } catch (Exception e) {

        }
    }

    @FXML
    void save(ActionEvent event) {
        Window stage = ((Node)event.getSource()).getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));
        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());//save the chosen directory
            data.save(file, fileChooser.getInitialDirectory());
        } catch (Exception e) {

        }
    }

    public void initialize(){
        fileChooser.setInitialDirectory(new File("C:\\"));

        changeDisplay.getItems().addAll("View All","View Complete","View Incomplete");
        changeDisplay.setValue("View All");

        complete.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        complete.setStyle("-fx-alignment: CENTER;");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        dueDate.setStyle("-fx-alignment: CENTER;");
        editList.setCellValueFactory(new PropertyValueFactory<>("editItem"));
        editList.setStyle("-fx-alignment: CENTER;");
        deleteList.setCellValueFactory(new PropertyValueFactory<>("deleteItem"));
        deleteList.setStyle("-fx-alignment: CENTER;");

        postInitialize();
    }

    public void transferData(DataHandler data) {
        this.data = data;
        changeDisplay.setValue(data.getViewType());

        numberOfItems.setText(data.list.getItemCount() + "/100 Items");
        postInitialize();
    }

    public void postInitialize() {
        changeDisplay.valueProperty().addListener((observable, oldValue, newValue) -> data.setViewType(changeDisplay.getValue()));

        FilteredList<Item> filteredList = new FilteredList<>(data.list.getItems(),p -> true);

        changeDisplay.valueProperty().addListener((observable, oldValue, newValue) -> {
            data.setViewType(newValue);
            filteredList.setPredicate(item -> {
                if(newValue == null || newValue == "View All") {
                    return true;
                }
                if(newValue == "View Complete" && item.getCompleted())
                    return true;
                if(newValue == "View Incomplete" && !item.getCompleted())
                    return  true;
                else
                    return false;
            });
        });

        data.list.getItems().addListener((ListChangeListener<Item>) c -> {
            numberOfItems.setText(data.list.getItemCount() + "/100 Items");
            listTable.getItems();
        });
        listTable.setItems(filteredList);
    }

    public void switchToAddScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Items.fxml"));
        Parent mainParent = loader.load();

        Scene mainScene = new Scene(mainParent);

        ItemsController controller = loader.getController();
        controller.transferData(data);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}
