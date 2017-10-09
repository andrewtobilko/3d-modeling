package com.tobilko;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/*
* symbols used in rules:
* 'F' - move and draw
* 'G' - move
* '+' - turn counterclockwise by angle
* '-' - turn clockwise by angle
* '[' - memorize position and angle
* ']' - restore last position and angle
* */
@Getter
@RequiredArgsConstructor
public final class LSystem {

    private final String axiom;
    private final Map<Character, String> rules;
    private final int n;
    private final int angle;

    public String transformToString() {
        final StringBuilder currentRule = new StringBuilder(axiom);

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

        return currentRule.toString();
    }
}
