package de.assertagile.workshop.groovy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("isOfAge return true for a birthday more then 18 years ago")
    void isOfAge1() {
        // given
        Person person = new Person("Andrea Aged", LocalDate.now().minusYears(59).plusDays(100));

        // expect
        assertTrue(person.isOfAge());
    }

    @Test
    @DisplayName("isOfAge return true for a birthday exactly 18 years ago")
    void isOfAge2() {
        // given
        Person person = new Person("Bear Lee Grownup", LocalDate.now().minusYears(18));

        // expect
        assertTrue(person.isOfAge());
    }

    @Test
    @DisplayName("isOfAge return false for a birthday just one day less then 18 years ago")
    void isOfAge3() {
        // given
        Person person = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1));

        // expect
        assertFalse(person.isOfAge());
    }

    @Test
    @DisplayName("isOfAge return false for a birthday less then 18 years ago")
    void isOfAge4() {
        // given
        Person person = new Person("Todd Ler", LocalDate.now().minusDays(300));

        // expect
        assertFalse(person.isOfAge());
    }

    @Test
    @DisplayName("equals is true & hashCode equals for two persons with equal properties")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode1() {
        // given
        Person first = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");
        Person second = new Person(first.getName(), first.getBirthday(), first.getEmailAddress());

        // expect
        assertTrue(first.equals(second));
        assertTrue(second.equals(first));
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("equals is false & hashCode differs if name differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode2() {
        // given
        Person first = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");
        Person second = new Person(first.getName() + "a", first.getBirthday(), first.getEmailAddress());

        // expect
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("equals is false & hashCode differs if name differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode3() {
        // given
        Person first = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");
        Person second = new Person("Diff A Rent", first.getBirthday(), first.getEmailAddress());

        // expect
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("equals is false & hashCode differs if birthday differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode4() {
        // given
        Person first = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");
        Person second = new Person(first.getName(), first.getBirthday().minusDays(4), first.getEmailAddress());

        // expect
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("equals is false & hashCode differs if email address differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode5() {
        // given
        Person first = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");
        Person second = new Person(first.getName(), first.getBirthday(), "tina.acher@rewe-digital.com");

        // expect
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("toString contains all property values")
    void toString1() {
        // given
        Person person = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1),"tina.acher@assertagile.de");

        // when
        String string = person.toString();

        // then
        assertAll(
                () -> assertTrue(string.contains(person.getName())),
                () -> assertTrue(string.contains(person.getBirthday().toString())),
                () -> assertTrue(string.contains(person.getEmailAddress()))
        );
    }
}