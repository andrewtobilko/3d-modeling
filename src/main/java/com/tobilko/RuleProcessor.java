package com.tobilko;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Stack;

/*
* symbols used in rules:
* 'F' - move and draw
* 'G' - move
* '+' - turn counterclockwise by angle
* '-' - turn clockwise by angle
* '[' - memorize position and angle
* ']' - restore last position and angle
* */
public class RuleProcessor {

    private final Stack<State> stack;
    private State currentState;
    private final int angle;
    private final int scale;

    private GraphicsContext context; // todo

    public RuleProcessor(Point point, int direction, int ang, int scale, GraphicsContext context) {
        currentState = new State(point, direction);
        angle = ang;
        this.scale = scale;
        stack = new Stack<>();
        this.context = context;
    }

    public void execute(String rule) {
        for (char ch: rule.toCharArray()) {
            int nextX, nextY;
            switch (ch) {
                case 'F' : {
                    Point currentPoint = currentState.getPoint();

                    nextX = currentPoint.getX() + (int) (scale * Math.cos(Math.toRadians(currentState.direction)));
                    nextY = currentPoint.getY() - (int) (scale * Math.sin(Math.toRadians(currentState.direction)));

                    Point nextPoint = Point.of(nextX, nextY);

                    ElementRenderer.drawLine(context, currentPoint, nextPoint);
                    currentState.setPoint(nextPoint);

                    break;
                }
                case 'G' : {
                    Point currentPoint = currentState.getPoint();

                    nextX = currentPoint.getX() + (int) (scale * Math.cos(Math.toRadians(currentState.direction)));
                    nextY = currentPoint.getY() - (int) (scale * Math.sin(Math.toRadians(currentState.direction)));

                    currentState.setPoint(Point.of(nextX, nextY));
                    break;
                }
                case '+' :
                    currentState.direction += angle;
                    if (currentState.direction > 359)
                        currentState.direction -= 360;
                    break;
                case '-' :
                    currentState.direction -= angle;
                    if (currentState.direction < 0)
                        currentState.direction += 360;
                    break;
                case '[' :
                    stack.push(currentState);
                    break;
                case ']' :
                    currentState = stack.pop();
                    break;
                default:
                    break;
            }
        }
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    private class State {

        private @NonNull Point point;
        private @NonNull int direction;

    }

}

