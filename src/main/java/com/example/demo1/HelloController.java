package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.animations.Shake;
import com.mysql.cj.protocol.Resultset;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button signin_btn;

    @FXML
    private Button signup_btn;

    @FXML
    void initialize() {
    signin_btn.setOnAction(actionEvent -> {
        String logintext = login_field.getText().trim();
        String passwordtext = password_field.getText().trim();

        if (!logintext.equals("") && !passwordtext.equals("")) {
            loginUser(logintext, passwordtext);
        }
        else
            System.out.println("Error");
    });

    signup_btn.setOnAction(actionEvent -> {
    signup_btn.getScene().getWindow().hide();
    openNewScene("sign_up.fxml");

});
    }

    private void loginUser(String logintext, String passwordtext) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(logintext);
        user.setPassword(passwordtext);
        ResultSet resultset = databaseHandler.getUser(user);

        int counter = 0;
try {
    while (resultset.next())
    {
        counter++;
    }
}
    catch (SQLException e)  {
    e.printStackTrace();
     }

        if (counter>=1) {
            signup_btn.getScene().getWindow().hide();
            openNewScene("app.fxml");
            System.out.println("Success!");
        }
        else {
            Shake userloginanimation = new Shake(login_field);
            Shake userpasswordanimation = new Shake(password_field);
            userloginanimation.playAnim();
            userpasswordanimation.playAnim();
        }
    }
    public void openNewScene (String window) {
        FXMLLoader fxmlLoader = new FXMLLoader(Signup_Controller.class.getResource(window));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
