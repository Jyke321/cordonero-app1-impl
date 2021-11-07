package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ApplicationController {

    private DataHandler data = new DataHandler();
    private final String MAIN = "MainRoot";
    private final String ADD = "AddRoot";

    @FXML
    private Button AddItem;

    @FXML
    private ComboBox<String> ChangeDisplay;

    @FXML
    private TableColumn<?, ?> Complete;

    @FXML
    private TableColumn<?, ?> DeleteList;

    @FXML
    private TableColumn<String, String> Description;

    @FXML
    private TableColumn<String, String> DueDate;

    @FXML
    private TableColumn<?, ?> EditList;

    @FXML
    private Button Guide;

    @FXML
    private TableView<?> ListTable;

    @FXML
    private Button LoadButton;

    @FXML
    private Label NumberOfItems;

    @FXML
    private Button SaveButton;

    @FXML
    private Button Cancel;

    @FXML
    private Button Confirm;

    @FXML
    private TextField EditDescription;

    @FXML
    private DatePicker EditDueDate;

    @FXML
    void AddItem(ActionEvent event) {
        try {
            switchToAddScene(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ClearItems(ActionEvent event) {

    }

    @FXML
    void Load(ActionEvent event) {
        Item newItem = new Item();
        data.list.addItem(newItem);
        NumberOfItems.setText(data.list.getItemCount() + "/100 Items");
    }

    @FXML
    void Save(ActionEvent event) {

    }

    @FXML
    void displayGuide(ActionEvent event) {

    }

    @FXML
    void Cancel(ActionEvent event) {
        try {
            returnToMainScene(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Confirm(ActionEvent event) throws IOException {
        Item newItem = new Item();
        if (newItem.validateDescription(EditDescription.getText()) &&
                newItem.validateDescription(EditDueDate.getConverter().toString())) {
            newItem.editDescription(EditDescription.getText());
            newItem.editDueDate(EditDueDate.getConverter().toString());
            data.list.addItem(newItem);
            returnToMainScene(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter proper values", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    @FXML
    void SetDate(ActionEvent event) {

    }

    @FXML
    void SetDescription(ActionEvent event) {

    }

    public void initialize(){
        try {
            ChangeDisplay.getItems().addAll("View All","View Complete","View Incomplete");
            NumberOfItems.setText(data.list.getItemCount() + "/100 Items");
            for (int i = 0; i < data.list.getItemCount(); i++) {
                Description.setText(data.list.getDescription(i));
                DueDate.setText(data.list.getDueDate(i));
            }
        } catch (Exception e) {

        }
    }

    public void switchToAddScene(ActionEvent event) throws IOException {
        data.scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Items.fxml"))));
        data.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        data.stage.setScene(data.scene);
        data.stage.show();
    }
    public void returnToMainScene(ActionEvent event) throws IOException {
        data.scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml"))));
        data.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        data.stage.setScene(data.scene);
        data.stage.show();
    }
}
