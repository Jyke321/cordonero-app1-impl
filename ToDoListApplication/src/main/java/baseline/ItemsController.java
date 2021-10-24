package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ItemsController {

    @FXML
    private Button AddItem;

    @FXML
    private Button Back;

    @FXML
    private TableColumn<?, ?> CompleteStatus;

    @FXML
    private TableColumn<?, ?> Deleteable;

    @FXML
    private TableColumn<?, ?> Description;

    @FXML
    private TableColumn<?, ?> DueDate;

    @FXML
    private TableColumn<?, ?> Editable;

    @FXML
    private Label NumberOfItems;

    @FXML
    private TextField Title;

    @FXML
    private Button View;

}
