package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Signup_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox checkbox_female;

    @FXML
    private CheckBox checkbox_male;

    @FXML
    private CheckBox checkbox_other;

    @FXML
    private Button signinreg_btn;

    @FXML
    private TextField signup_country;

    @FXML
    private TextField signup_firstname;

    @FXML
    private TextField signup_lastname;

    @FXML
    private TextField signup_login;

    @FXML
    private TextField signup_password;

    @FXML
    void initialize() {

signinreg_btn.setOnAction(actionEvent -> {
    signupNewuser();
   });
    }

    private void signupNewuser() {
        DatabaseHandler databaseHandler=new DatabaseHandler();

        String firstname = signup_firstname.getText();
        String lastname = signup_lastname.getText();
        String login = signup_login.getText();
        String password = signup_password.getText();
        String region = signup_country.getText();
        String gender = "";
        if (checkbox_male.isSelected())
            gender="Male";
        if (checkbox_female.isSelected())
            gender="Female";
        else
            gender="Other";
        User user = new User(firstname,lastname,login,password,region,gender);

        databaseHandler.signupUser(user);

    }

}
