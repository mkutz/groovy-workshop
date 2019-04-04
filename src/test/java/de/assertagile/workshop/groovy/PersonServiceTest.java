package de.assertagile.workshop.groovy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonServiceTest {

    private static final Person TODD = new Person("Todd Ler", LocalDate.now().minusDays(300));
    private static final Person TINA = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1), "tina.acher@assertagile.de");
    private static final Person BEAR = new Person("Bear Lee Grownup", LocalDate.now().minusYears(18), "bear.lee.grownup@assertagile.de");
    private static final Person ANDREA = new Person("Andrea Aged", LocalDate.now().minusYears(59).plusDays(100));

    @Test
    @DisplayName("getAllPersons returns empty list initially")
    void getAllPersons1() {
        // given
        PersonService service = new PersonService();

        // expect
        assertEquals(service.getAllPersons(), Set.of());
    }

    @Test
    @DisplayName("getAllPersons returns all persons added")
    void getAllPersons2() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.getAllPersons(), Set.of(TODD, TINA, BEAR, ANDREA));
    }

    @Test
    @DisplayName("findPerson returns the named person")
    void findPerson1() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.findPerson(TODD.getName()), Optional.of(TODD));
    }

    @Test
    @DisplayName("findPerson an empty optional if name is unknown")
    void findPerson2() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertTrue(service.findPerson("Unknown").isEmpty());
    }

    @Test
    @DisplayName("findPersons returns all persons matching the given pattern")
    void findPersonsPattern1() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.findPersons(Pattern.compile("^T.*$")), Set.of(TINA, TODD));
    }

    @Test
    @DisplayName("findPersons returns all persons with the given birthday")
    void findPersonsLocalDate1() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.findPersons(ANDREA.getBirthday()), Set.of(ANDREA));
    }

    @Test
    @DisplayName("findPersons returns all persons matching the given pattern object")
    void findPersonsByObject1() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.findPersons((Object) Pattern.compile("^T.*$")), Set.of(TINA, TODD));
    }

    @Test
    @DisplayName("findPersons returns all persons with the given birthday object")
    void findPersonsByObject2() {
        // given
        PersonService service = new PersonService();
        service.addPersons(TODD, TINA, BEAR, ANDREA);

        // expect
        assertEquals(service.findPersons((Object) ANDREA.getBirthday()), Set.of(ANDREA));
    }
}