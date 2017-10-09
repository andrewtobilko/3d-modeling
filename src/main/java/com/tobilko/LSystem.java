package com.tobilko;

import lombok.RequiredArgsConstructor;
import java.util.HashMap;

/*
* symbols used in rules:
* 'F' - move and draw
* 'G' - move
* '+' - turn counterclockwise by angle
* '-' - turn clockwise by angle
* '[' - memorize position and angle
* ']' - restore last position and angle
* */
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
                    currentRule.replace(j, j + 1, rule);
                    j += rule.length() - 1;
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
                60).display(50, 50, 0, 10);
    }
}


