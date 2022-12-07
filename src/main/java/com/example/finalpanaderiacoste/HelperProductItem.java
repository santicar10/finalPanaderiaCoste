package com.example.finalpanaderiacoste;

import javafx.fxml.FXMLLoader;


public class HelperProductItem {
    public  FXMLLoader fxmlLoader = new FXMLLoader();

    public  void setLocation(){
        fxmlLoader.setLocation(getClass().getResource("menu-item.fxml"));
    }

}
