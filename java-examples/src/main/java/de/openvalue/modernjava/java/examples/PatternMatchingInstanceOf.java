package de.openvalue.modernjava.java.examples;

import java.util.List;

class PatternMatchingInstanceOf {

    public static void main(String[] args) {
        matchPattern(1);
        matchPattern("12345");
        matchPattern("123456");
        matchPattern(List.of());
    }

    private static void matchPattern(Object object) {
        // 1. use pattern matching for instanceof to assign the integer to a variable
        // 2. assign the string to a variable and collapse the if statement
        if(object instanceof Integer) {
            System.out.println(((Integer) object) + 1);
        } else if(object instanceof String) {
            var string = (String) object;
            if(string.length() <= 5) {
                System.out.println(string);
            }
        }
    }
}
