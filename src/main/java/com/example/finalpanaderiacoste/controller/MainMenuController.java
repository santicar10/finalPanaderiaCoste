package com.example.finalpanaderiacoste.controller;

import com.example.finalpanaderiacoste.HelperProductItem;
import com.example.finalpanaderiacoste.alerts.AlertController;
import com.example.finalpanaderiacoste.exceptions.InputException;
import com.example.finalpanaderiacoste.exceptions.ProductException;
import com.example.finalpanaderiacoste.model.Product;
import com.example.finalpanaderiacoste.services.impl.ProductoImpl;
import com.example.finalpanaderiacoste.validations.InputValidation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    ArrayList<Product> productsVentaLista = new ArrayList<>();
    @FXML
    private TextField amountEdit;

    @FXML
    private Button buttonCrear;

    @FXML
    private Button confirmButton;

    @FXML
    private GridPane containerProducts;

    @FXML
    private TextField deleteCode;

    @FXML
    private Button editButton;

    @FXML
    private TextField editCode;

    @FXML
    private TextField inputCantidad;

    @FXML
    private TextField inputId;

    @FXML
    private TextField inputNombre;

    @FXML
    static private Label labelVenta;

    static private String labelMessage="...";

    public static void changeText(String product){
        labelMessage += product + "\n";
        labelVenta.setText(labelMessage);
    }

    @FXML
    private TextField inputPrice;

    @FXML
    private TextField inputUrlImage;

    @FXML
    private TextField priceEdit;

    @FXML
    private Button searchEditProductButton;

    @FXML
    private TextField urlEdit;

    final int[] columns = {0};
    final int[] rows = {1};

    void showProducts() {

        mfc.panaderiaCoste.getProductService().getProductArrayList().stream().forEach(product -> {
            try {

                HelperProductItem helperProductItem = new HelperProductItem();
                helperProductItem.setLocation();
                System.out.println(product.getName());
                VBox vBox = helperProductItem.fxmlLoader.load();
                ProductItemController productItemController = helperProductItem.fxmlLoader.getController();
                productItemController.setValues(product,labelVenta,productsVentaLista);
                if (columns[0] == 2) {
                    columns[0] = 0;
                    rows[0]++;
                }
                containerProducts.add(vBox, columns[0]++, rows[0]);
                GridPane.setMargin(vBox, new Insets(15, 30, 50, 20)
                );


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    void createProduct() {

        try {
            InputValidation.isInputFilled(inputNombre.getText());
            InputValidation.isInputFilled(inputCantidad.getText());
            InputValidation.isInputFilled(inputId.getText());
            InputValidation.isInputFilled(inputUrlImage.getText());
            InputValidation.isInputFilled(inputPrice.getText());

            InputValidation.verifyInputNumerical(inputPrice.getText());
            InputValidation.verifyInputNumerical(inputCantidad.getText());

            mfc.panaderiaCoste.getProductService()

                    .addProduct(
                            inputNombre.getText(),
                            Integer.parseInt(inputCantidad.getText()),
                            Double.parseDouble(inputPrice.getText()),
                            inputId.getText(),
                            inputUrlImage.getText()

                    );
            containerProducts.getChildren().clear();
            showProducts();
        } catch (InputException err) {
            System.out.println(err.getMessage());
        } catch (ProductException e) {
            throw new RuntimeException(e);
        }
    }

    Product productEditable;

    @FXML
    void searchProductForEdit() {

        try {
            productEditable = mfc.panaderiaCoste.getProductService().searchProductById(editCode.getText());
            AlertController.informationMessage("Producto encontrado, nombre:" + productEditable.getName());
            amountEdit.setText(productEditable.getAmount() + "");
            priceEdit.setText((int) productEditable.getPrice() + "");
            urlEdit.setText(productEditable.getUrlImage());

        } catch (ProductException err) {
            AlertController.errMessage(err.getMessage());
        }

    }

    @FXML
    void editProduct() {

        try {
            InputValidation.isInputFilled(amountEdit.getText());
            InputValidation.isInputFilled(priceEdit.getText());
            InputValidation.isInputFilled(urlEdit.getText());
            InputValidation.verifyInputNumerical(priceEdit.getText());
            InputValidation.verifyInputNumerical(amountEdit.getText());

            mfc.panaderiaCoste.getProductService().editProduct(productEditable, Integer.parseInt(amountEdit.getText()), Integer.parseInt(priceEdit.getText()), urlEdit.getText());
            containerProducts.getChildren().clear();
            showProducts();
        } catch (InputException err) {

            AlertController.errMessage(err.getMessage());

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProducts();
    }

    @FXML
    void deleteProduct() {
        try {
            InputValidation.isInputFilled(deleteCode.getText());
            mfc.panaderiaCoste.getProductService().deleteProduct(deleteCode.getText());
            containerProducts.getChildren().clear();
            showProducts();

        } catch (InputException err) {

            AlertController.errMessage("debe agregar un codigo");

        } catch (ProductException e) {
            AlertController.errMessage(e.getMessage());
        }
    }

    @FXML
    void confimSale(){

        mfc.panaderiaCoste.getProductService().restAmounts(productsVentaLista);

        productsVentaLista.clear();

        containerProducts.getChildren().clear();
        showProducts();

    }
}
