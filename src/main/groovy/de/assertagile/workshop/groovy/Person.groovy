package de.assertagile.workshop.groovy

import groovy.transform.Immutable

import java.time.LocalDate

@Immutable
class Person {

    final String name
    final LocalDate birthday
    final String emailAddress

    boolean isOfAge() {
        !LocalDate.now().minusYears(18).isBefore(birthday)
    }
}
