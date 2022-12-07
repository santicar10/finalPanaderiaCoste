module com.example.finalpanaderiacoste {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    exports com.example.finalpanaderiacoste;
    opens com.example.finalpanaderiacoste to javafx.fxml;

    exports com.example.finalpanaderiacoste.controller;
    opens com.example.finalpanaderiacoste.controller to javafx.fxml;
}