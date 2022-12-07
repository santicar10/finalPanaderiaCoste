package com.example.finalpanaderiacoste;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private static Stage stage;
    private  static Scene scene;
    private static Parent root;

    public static void sceneMainMenu(ActionEvent e) throws IOException{

        switchScene(e,"menu-principal.fxml");

    }

    public static void switchScene(ActionEvent e, String resource) throws IOException {
        root = FXMLLoader.load(SceneController.class.getResource(resource));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 899, 638);
        stage.setScene(scene);
        stage.show();
    }
}
