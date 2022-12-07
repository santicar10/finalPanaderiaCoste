package com.example.finalpanaderiacoste.controller;

import com.example.finalpanaderiacoste.SceneController;
import com.example.finalpanaderiacoste.alerts.AlertController;
import com.example.finalpanaderiacoste.exceptions.LoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField inputName;

    @FXML
    private PasswordField inputPassword;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    void loginUser(ActionEvent e){

        try{

            mfc.panaderiaCoste.getLoginService()
                    .login(
                            inputName.getText(),
                            inputPassword.getText()
                    );
            SceneController.sceneMainMenu(e);

        }catch (LoginException err){

            AlertController.errMessage(err.getMessage());


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }






}
