package com.tobilko.lab1;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
@RequiredArgsConstructor
public final class LSystemRenderer {

    private final InitialRenderParameters parameters;
    private final LSystem system;
    private final GraphicsContext context;

    public void render() {
        final RuleProcessor processor = new RuleProcessor(
                parameters.getPoint(),
                parameters.getDirection(),
                system.getAngle(),
                parameters.getScale(),
                context
        );

        processor.execute(system.transformToString());
    }

    @Getter
    @RequiredArgsConstructor(staticName = "of")
    public static class InitialRenderParameters {
        private final Point point;
        private final int direction;
        private final int scale;
    }

}
