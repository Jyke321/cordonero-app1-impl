package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ApplicationController {

    @FXML
    private Button AddList;

    @FXML
    private TableColumn<?, ?> DeleteList;

    @FXML
    private TableColumn<?, ?> EditList;

    @FXML
    private TableView<?> ListTable;

    @FXML
    private Button LoadButton;

    @FXML
    private Label NumberOfLists;

    @FXML
    private TableColumn<?, ?> Save;

    @FXML
    private Button SaveButton;

    @FXML
    private TableColumn<?, ?> ToDoLists;

}
