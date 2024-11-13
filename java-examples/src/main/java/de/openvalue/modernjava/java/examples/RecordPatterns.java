package de.openvalue.modernjava.java.examples;

class RecordPatterns {
    // use a record pattern to simplify this
    record Point(int x, int y) {}

    static void printSum(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x+y);
        }
    }

    public static void main(String[] args) {
        printSum(new Point(1, 2));
        printSum("something random");
    }
}
