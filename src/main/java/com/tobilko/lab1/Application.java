package com.tobilko.lab1;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;


/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public final class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new ApplicationModule());

        configureStageWithInjector(stage, injector);
        stage.show();
    }

    private void configureStageWithInjector(Stage stage, Injector injector) {
        Group root = new Group();

        root.getChildren().add(injector.getInstance(Canvas.class));

        injector.getInstance(LSystemRenderer.class).render();

        stage.setScene(new Scene(root));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
