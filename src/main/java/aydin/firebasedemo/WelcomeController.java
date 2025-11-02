package aydin.firebasedemo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class WelcomeController {

    @FXML
    private Button registerButton;

    @FXML
    private Button signInButton;

    @FXML
    private void switchTo(String page) throws IOException {
        DemoApp.setRoot(page);
    }

    @FXML
    void registerButtonClicked(ActionEvent event) {
        try {
            switchTo("register");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void signInButtonClicked(ActionEvent event) {
        try {
            switchTo("signin");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
