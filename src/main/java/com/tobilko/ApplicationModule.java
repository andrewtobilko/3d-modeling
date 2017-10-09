package com.tobilko;

import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import javafx.scene.canvas.Canvas;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {}

    @Provides
    @Singleton
    private Canvas getCanvas() {
        return new Canvas(1000, 1000);
    }

    @Singleton
    private LSystem getLSystem() {
        return new LSystem(
                "X",
                ImmutableMap.of('X', "F-[[X]+X]+F[+FX]-X"),
                6,
                22);
    }

    @Singleton
    private LSystemRenderer.InitialRenderParameters getInitialRenderParameters() {
        return LSystemRenderer.InitialRenderParameters.of(
            Point.of(500, 800),
                90,
                50
        );
    }

    @Provides
    @Singleton
    private LSystemRenderer getRenderer(Canvas canvas) {
        return new LSystemRenderer(
                getInitialRenderParameters(),
                getLSystem(),
                canvas.getGraphicsContext2D()
        );
    }

}
