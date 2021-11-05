package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jacob Cordonero
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ApplicationController {

    @FXML
    private Button AddItem;

    @FXML
    private ChoiceBox<?> ChangeDisplay;

    @FXML
    private TableColumn<?, ?> Complete;

    @FXML
    private TableColumn<?, ?> DeleteList;

    @FXML
    private TableColumn<?, ?> Description;

    @FXML
    private TableColumn<?, ?> DueDate;

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
    void AddItem(ActionEvent event) {

    }

    @FXML
    void ClearItems(ActionEvent event) {

    }

    @FXML
    void Load(ActionEvent event) {

    }

    @FXML
    void Save(ActionEvent event) {

    }

    @FXML
    void displayGuide(ActionEvent event) {

    }

}
