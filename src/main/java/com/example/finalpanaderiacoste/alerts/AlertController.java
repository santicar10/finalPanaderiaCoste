package com.example.finalpanaderiacoste.alerts;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AlertController {

    public static void errMessage (String message){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Se ha encontrado un error");
        Label label = new Label("Infomacion del error:");
        TextArea textArea = new TextArea(message);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea,Priority.ALWAYS);
        GridPane content = new GridPane();
        content.setMaxWidth(Double.MAX_VALUE);
        content.add(label,0,0);
        content.add(textArea,0,1);
        alert.getDialogPane().setExpandableContent(content);
        alert.showAndWait();
    }
    public static void informationMessage(String message){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de información");
        alert.setTitle("Dialogo de información");
        alert.setContentText(message);
        alert.showAndWait();

    }
}
