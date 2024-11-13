package de.openvalue.modernjava.java.examples;

class HelpfulNullPointerExceptions {

    public static void main(String[] args) {
        // 1. run as is
        // 2. run with -XX:-ShowCodeDetailsInExceptionMessages in vm options
        String nullValue = null;
        nullValue.chars();
    }
}
