package com.example.finalpanaderiacoste;

import com.example.finalpanaderiacoste.controller.ModelFactoryController;
import com.example.finalpanaderiacoste.model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kotlin.comparisons.UComparisonsKt;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ModelFactoryController mfc = ModelFactoryController.getInstance();
        mfc.panaderiaCoste.getProductService().startProducts();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 704, 515);
        stage.setTitle("COSTE");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}