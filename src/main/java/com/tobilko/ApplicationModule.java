package com.tobilko;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Canvas.class).toInstance(getCanvas());
    }

    private Canvas getCanvas() {
        return new Canvas(1000, 1000);
    }

}
