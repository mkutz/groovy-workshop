package de.assertagile.workshop.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@EqualsAndHashCode
@ToString
class Person {

    final String name
    final LocalDate birthday
    String emailAddress

    Person(String name, LocalDate birthday, String emailAddress = null) {
        this.name = name
        this.birthday = birthday
        this.emailAddress = emailAddress
    }

    boolean isOfAge() {
        !LocalDate.now().minusYears(18).isBefore(birthday)
    }
}
