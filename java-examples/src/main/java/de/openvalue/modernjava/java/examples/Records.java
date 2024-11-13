package de.openvalue.modernjava.java.examples;

import java.util.Objects;

class Records {

    public static void main(String[] args) {
        // 1. turn Point into a record
        // 2. use simpler canonical constructor: Point { }
        // 3. modify x, y in constructor and getters
        // 4. create minimal record

        var point = new Point(1, 2);
        System.out.println("equals: " + point.equals(new Point(2, 1)));
        System.out.println("hashCode: " + point.hashCode());
        System.out.println("toString: " + point.toString());
    }

    private static final class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() { return x; }
        public int y() { return y; }

        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point other = (Point) o;
            return other.x == x && other.y == y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return String.format("Point[x=%d, y=%d]", x, y);
        }
    }

}
