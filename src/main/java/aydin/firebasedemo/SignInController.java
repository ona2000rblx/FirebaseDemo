package aydin.firebasedemo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private TextField usernameTextBox;


    @FXML
    private void switchTo(String page) throws IOException {
        DemoApp.setRoot(page);
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {
        try {
            switchTo("welcome");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public UserRecord signInUser() {
        UserRecord userRecord;

        try {
            userRecord = DemoApp.fauth.getUserByEmail(usernameTextBox.getText());
            System.out.println("Successfully Created User -> " + userRecord.getUid());

            return userRecord;
        }
        catch (FirebaseAuthException e) {
            e.printStackTrace();
            System.out.println("Error creating user");
            return null;
        }
    }

    @FXML
    void signInButtonClicked(ActionEvent event) {
        UserRecord user = signInUser();

        if(user != null) {
            try {
                switchTo("primary");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
