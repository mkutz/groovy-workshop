package de.assertagile.workshop.groovy

import java.time.LocalDate
import java.util.function.Predicate
import java.util.regex.Pattern

import static java.util.stream.Collectors.toSet

public class PersonService {

    private Set<Person> persons = new HashSet<>();

    public Collection<Person> getAllPersons() {
        return persons;
    }

    public Optional<Person> findPerson(String name) {
        return persons.stream()
                .filter({ person -> person.getName().equals(name) })
                .findFirst();
    }

    public Collection<Person> findPersons(LocalDate birthday) {
        return persons.stream()
                .filter({ person -> person.getBirthday().equals(birthday) })
                .collect(toSet());
    }

    public Collection<Person> findPersons(Pattern regex) {
        return persons.stream()
                .filter({ person -> regex.matcher(person.getName()).matches() })
                .collect(toSet());
    }

    public Collection<Person> findPersons(Predicate<? super Person> predicate) {
        return persons.stream().filter(predicate).collect(toSet());
    }

    public Collection<Person> findPersons(Object criteria) {
        throw new IllegalArgumentException("This is not implemented, yet!");
    }

    public void addPersons(Person... persons) {
        this.persons.addAll(Arrays.asList(persons));
    }
}
