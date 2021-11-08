package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemsController {

    private DataHandler data = new DataHandler();

    @FXML
    private DatePicker datePicker;
    @FXML
    private Text descriptionLength;

    @FXML
    private TextField editDescription;

    @FXML
    private TextField editDueDate;

    @FXML
    void cancel(ActionEvent event) {
        try {
            returnToMainScene(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
        Item newItem = new Item();
        if (newItem.validateDescription(editDescription.getText()) &&
                newItem.validateDueDate(editDueDate.getText())) {
            newItem.editDescription(editDescription.getText());
            newItem.editDueDate(editDueDate.getText());
            data.list.addItem(newItem);
            returnToMainScene(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter proper values", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    public void initialize() {
        editDescription.textProperty().addListener((observable, oldValue, newValue) -> descriptionLength.setText("Edit Description: (" + editDescription.getText().length() + "/256)"));
    }

    @FXML
    void setDate() {
        editDueDate.setText(datePicker.getValue().toString());
    }
    @FXML
    void setDescriptionLength() {
        descriptionLength.setText("Edit Description: (" + 2 + "/128)");
    }

    public void transferData(DataHandler data) {
        //gets data from previous scene
        this.data = data;
    }

    public void returnToMainScene(ActionEvent event) throws IOException {
        //create new FXML loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Application.fxml"));
        Parent itemsParent = loader.load();
        //set scene to the parent from loaded from loader
        Scene itemsScene = new Scene(itemsParent);
        //get the controller from the loader
        ApplicationController controller = loader.getController();
        controller.transferData(data);//send data to previous scene
        //show new scene on the stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(itemsScene);
        window.show();
    }
}
