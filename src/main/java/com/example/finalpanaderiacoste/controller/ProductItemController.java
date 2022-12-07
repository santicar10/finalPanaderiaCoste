package com.example.finalpanaderiacoste.controller;

import com.example.finalpanaderiacoste.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ProductItemController {
    @FXML
    private Button addButton;

    @FXML
    private Label amountPriceProduct;

    @FXML
    private ImageView imageProduct;

    @FXML
    private Label textNameProduct;

    @FXML
    private Label textPriceProduct;

    Label label;
    ArrayList<Product> productArrayList;



    Product product;

    public void setValues(Product product, Label label, ArrayList<Product>productArrayList){
        this.product = product;
        Image image = new Image(product.getUrlImage());
        imageProduct.setImage(image);
        textNameProduct.setText(product.getName());
        textPriceProduct.setText("$"+ product.getPrice());
        amountPriceProduct.setText(""+product.getAmount());
        this.label = label;
        this.productArrayList = productArrayList;
    }

    public void addToVenta() {
        MainMenuController.changeText(product.getName());
        productArrayList.add(product);


    }

    public Button getAddButton() {
        return addButton;
    }
}
