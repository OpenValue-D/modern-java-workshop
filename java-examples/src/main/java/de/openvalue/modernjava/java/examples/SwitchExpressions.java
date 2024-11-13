package de.openvalue.modernjava.java.examples;

class SwitchExpressions {
    private enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

    public static void main(String[] args) {
        // 1. turn this into a switch expression
        // 2. use multiline with yield
        int numLetters = 0;
        Day day = Day.WEDNESDAY;
            switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);
    }

}
