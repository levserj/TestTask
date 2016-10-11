package com.levserj.test.task.sg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serhii Levchynskyi on 14.07.2016.
 *
 * For this task we need to sort random points to receive
 * no crossing lines if we connect them in this order.
 * To do that we'll need to sort them by x coordinate,
 * if x are equal, then compare y coordinates.
 * This way the resulting line won't go back and cross other lines.
 */
public class QuestionFour {

    private static class Point {

        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        Point() {
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {

        /* Let's create some random points. */
        List<Point> points = new ArrayList<>();
        System.out.println("Input points list");
        System.out.println("------------------");
        for (int i = 0; i < 7; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            points.add(new Point(x, y));
            System.out.println("X = " + x + " Y = " + y);
        }
        System.out.println("------------------");
        /* Then sort them with the specified comparator. */
        Collections.sort(points, (o1, o2) -> {
            if (o1.getX() != o2.getX()) return o1.getX() - o2.getX();
            if (o1.getY() != o2.getY()) return o1.getY() - o2.getY();
            return 0;
        });
        System.out.println("Sorted points list");
        System.out.println("------------------");
        for (Point p : points) {
            System.out.println("X = " + p.getX() + " Y = " + p.getY());
        }
        System.out.println("------------------");
    }
}
