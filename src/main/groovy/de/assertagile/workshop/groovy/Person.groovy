package de.assertagile.workshop.groovy

import java.time.LocalDate

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

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Person person = (Person) o

        if (birthday != person.birthday) return false
        if (emailAddress != person.emailAddress) return false
        if (name != person.name) return false

        return true
    }

    int hashCode() {
        int result
        result = name.hashCode()
        result = 31 * result + birthday.hashCode()
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0)
        result
    }

    @Override
    String toString() {
        "Person{name='$name', birthday=$birthday, emailAddress='$emailAddress'}"
    }
}
