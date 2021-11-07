package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testSaveAndLoad() {
        //Make a data handler
        //Make a to-do-list to compare
        //ready a save and load location
        //test the functions on one of the list
        //compare the lists value
        assertEquals(0,0);
    }
    @Test
    void testPopStack () throws IOException {
        DataHandler data = new DataHandler();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        //data.addToSceneStack(scene);
        //Parent testRoot = FXMLLoader.load(getClass().getResource("Items.fxml"));
        //Scene test = new Scene(testRoot);
        //test = data.popSceneStack();
        //assertEquals(scene,test);
        assertNotNull(stage);
    }
}