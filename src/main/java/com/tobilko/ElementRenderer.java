package com.tobilko;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public final class ElementRenderer {

    public static void drawLine(GraphicsContext context, Point a, Point b) {
        context.setFill(Color.BLACK);
        context.setStroke(Color.BLACK);
        context.setLineWidth(5);
        context.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

}
