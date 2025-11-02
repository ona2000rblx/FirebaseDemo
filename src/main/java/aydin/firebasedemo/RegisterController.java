package aydin.firebasedemo;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.io.IOException;

public class RegisterController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailTextBox;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTextBox;

    @FXML
    private Label message;

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

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(emailTextBox.getText())
                .setEmailVerified(false)
                .setPassword(passwordTextBox.getText())
                .setDisplayName(usernameTextBox.getText())
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        }

    }

    @FXML
    void registerButtonClicked(ActionEvent event) {
        boolean result = registerUser();

        if (result){
            message.setText("Registration Successful");
        }else{
            message.setText("Registration Failed");
        }
    }

}
