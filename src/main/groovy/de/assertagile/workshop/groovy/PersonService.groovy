package de.assertagile.workshop.groovy

import java.time.LocalDate
import java.util.function.Predicate
import java.util.regex.Pattern

class PersonService {

    private Set<Person> persons = []

    Collection<Person> getAllPersons() {
        return persons
    }

    Optional<Person> findPerson(String name) {
        Optional.ofNullable(persons.find { it.name == name })
    }

    Collection<Person> findPersons(LocalDate birthday) {
        persons.findAll { it.birthday == birthday }
    }

    Collection<Person> findPersons(Pattern regex) {
        persons.findAll { it.name ==~ regex }
    }

    Collection<Person> findPersons(Predicate<? super Person> predicate) {
        persons.findAll { predicate.test(it) }
    }

    Collection<Person> findPersons(Object criteria) {
        throw new IllegalArgumentException("This is not implemented, yet!")
    }

    void addPersons(Person... persons) {
        this.persons.addAll(persons)
    }
}
