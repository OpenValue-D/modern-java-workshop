package de.openvalue.modernjava.java.examples;

import java.util.List;

class PatternMatchingSwitch {
    public static void main(String[] args) {
        System.out.println(formatter(1));
        System.out.println(formatter(2L));
        System.out.println(formatter(3.0D));
        System.out.println(formatter("4"));
        System.out.println(formatter("55"));
        System.out.println(formatter(List.of()));
    }

    private static String formatter(Object obj) {
        // 1. use pattern matching for switch here
        // 2. use when to flatten the nested if statement
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            if(s.length() < 2) {
                formatted = "too-short";
            } else {
                formatted = String.format("String %s", s);
            }
        }
        return formatted;
    }
}
