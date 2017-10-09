package com.tobilko;

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
    private class State {
        private int x, y, direction;
        public State(int ix, int iy, int dir) {
            x = ix;
            y = iy;
            direction = dir;
        }
    }
    private State currentState;
    private int angle;
    private int scale;

    public RuleProcessor(int startX, int startY, int direction, int ang, int scale) {
        currentState = new State(startX, startY, direction);
        angle = ang;
    }

    private Stack<State> stack = new Stack<State>();

    public void execute(String rule) {
        for (char ch: rule.toCharArray()) {
            int nextX, nextY;
            switch (ch) {
                case 'F' :
                    nextX = currentState.x + (int)(scale*Math.cos(Math.toRadians(currentState.direction)));
                    nextY = currentState.y - (int)(scale*Math.sin(Math.toRadians(currentState.direction)));
                    //drawLine(currentState.x, currentState.y, nextX, nextY);
                    currentState.x = nextX;
                    currentState.y = nextY;
                    break;
                case 'G' :
                    nextX = currentState.x + (int)(scale*Math.cos(Math.toRadians(currentState.direction)));
                    nextY = currentState.y - (int)(scale*Math.sin(Math.toRadians(currentState.direction)));
                    currentState.x = nextX;
                    currentState.y = nextY;
                    break;
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
}

