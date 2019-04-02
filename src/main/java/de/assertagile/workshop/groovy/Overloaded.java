package de.assertagile.workshop.groovy;

public class Overloaded {

    static int method(String arg) {
        System.out.println(arg);
        return 1;
    }

    static int method(Object arg) {
        System.out.println(arg);
        return 2;
    }
}
