package com.tobilko;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public final class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {

        Root root = new FXMLLoader(new File("src/main/resources/application.fxml").toURI().toURL()).load();

        stage.setScene(new Scene(new FXMLLoader(new File("src/main/resources/application.fxml").toURI().toURL()).load()));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
