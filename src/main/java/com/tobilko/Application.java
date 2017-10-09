package com.tobilko;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.inject.Inject;


/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public final class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new ApplicationModule());
        Group root = new Group();

        root.getChildren().add(injector.getInstance(Canvas.class));
        stage.setScene(new Scene(root));
        stage.show();

    }

    private void drawLine(Point a, Point b) {
//        context.setFill(Color.BLACK);
//        context.setStroke(Color.BLACK);
//        context.setLineWidth(5);
//        context.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
