package com.tobilko;

import com.sun.javafx.css.Rule;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Stack;

@RequiredArgsConstructor
public final class LSystem {
    private final String axiom;
    private final HashMap<Character, String> rules;
    private final int n;
    private final int angle;

    public void display(int initX, int initY, int initAngle, int scale) {
        StringBuilder currentRule = new StringBuilder(axiom);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < currentRule.toString().length(); ++j) {
                char c = currentRule.charAt(j);
                if (rules.containsKey(c)) {
                    String rule = rules.get(c);
                    currentRule.replace(j, j+1, rule);
                    j += rule.length()-1;
                }
            }
        }
        new RuleProcessor(initX, initY, initAngle, angle, scale).execute(currentRule.toString());
    }
}

class A {
    public static void main(String[] args) {
        HashMap<Character, String> rules = new HashMap<>();
        rules.put('R', "abR");
        rules.put('F', "9");
        new LSystem(
                "+RFY",
                rules,
                5,
                60).display(50,50, 0, 10);
    }
}


/*
* symbols used in rules:
* 'F' - move and draw
* 'G' - move
* '+' - turn counterclockwise by angle
* '-' - turn clockwise by angle
* '[' - memorize position and angle
* ']' - restore last position and angle
* */
class RuleProcessor {
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

    private Stack<State> stack;

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

                    break;
                case ']' :

                    break;
                default:
                    break;
            }
        }
    }
}
