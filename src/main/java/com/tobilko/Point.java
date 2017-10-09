package com.tobilko;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Andrew Tobilko on 10/9/17.
 */
@Getter
@RequiredArgsConstructor(staticName = "of")
public final class Point {
    private final int x;
    private final int y;

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
}
