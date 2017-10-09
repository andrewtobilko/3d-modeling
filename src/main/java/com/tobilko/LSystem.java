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

    public void display(int initX, int initY, int initAngle) {
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
        new RuleProcessor(initX, initY, initAngle-angle).execute(currentRule.toString());
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
                60).display(50,50, 0);
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
    @RequiredArgsConstructor
    private class State {
        private final int x, y, direction;
    }
    State currentState;
    public RuleProcessor(int startX, int startY, int direction) {
        currentState = new State(startX, startY, direction);
    }

    private Stack<State> stack;

    public void execute(String rule) {
        for (char ch: rule.toCharArray()) {
            int nextX, nextY;
            switch (ch) {
                case 'F' :


                    break;
                case 'G' :

                    break;
                case '+' :

                    break;
                case '-' :

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
