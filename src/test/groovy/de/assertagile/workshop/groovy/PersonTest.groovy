package de.assertagile.workshop.groovy

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import static java.time.LocalDate.now as today
import static org.junit.jupiter.api.Assertions.*

class PersonTest {

    @Test
    @DisplayName("isOfAge return true for a birthday more then 18 years ago")
    void isOfAge1() {
        // given
        Person person = new Person("Andrea Aged", today().minusYears(59).plusDays(100), null)

        // expect
        assertTrue(person.ofAge)
    }

    @Test
    @DisplayName("isOfAge return true for a birthday exactly 18 years ago")
    void isOfAge2() {
        // given
        Person person = new Person("Bear Lee Grownup", today().minusYears(18), null)

        // expect
        assertTrue(person.ofAge)
    }

    @Test
    @DisplayName("isOfAge return false for a birthday just one day less then 18 years ago")
    void isOfAge3() {
        // given
        Person person = new Person("Tina Acher", today().minusYears(18).plusDays(1), null)

        // expect
        assertFalse(person.ofAge)
    }

    @Test
    @DisplayName("isOfAge return false for a birthday less then 18 years ago")
    void isOfAge4() {
        // given
        Person person = new Person("Todd Ler", today().minusDays(300), null)

        // expect
        assertFalse(person.ofAge)
    }

    @Test
    @DisplayName("equals is true & hashCode equals for two persons with equal properties")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode1() {
        // given
        Person first = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
        Person second = new Person(first.name, first.birthday, first.emailAddress)

        // expect
        assertTrue(first == second)
        assertTrue(second == first)
        assertEquals(first.hashCode(), second.hashCode())
    }

    @Test
    @DisplayName("equals is false & hashCode differs if name differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode2() {
        // given
        Person first = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
        Person second = new Person(first.name + "a", first.birthday, first.emailAddress)

        // expect
        assertFalse(first == second)
        assertNotEquals(first.hashCode(), second.hashCode())
    }

    @Test
    @DisplayName("equals is false & hashCode differs if name differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode3() {
        // given
        Person first = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
        Person second = new Person("Diff A Rent", first.birthday, first.emailAddress)

        // expect
        assertFalse(first == second)
        assertFalse(second == first)
        assertNotEquals(first.hashCode(), second.hashCode())
    }

    @Test
    @DisplayName("equals is false & hashCode differs if birthday differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode4() {
        // given
        Person first = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
        Person second = new Person(first.name, first.birthday.minusDays(4), first.emailAddress)

        // expect
        assertFalse(first == second)
        assertFalse(second == first)
        assertNotEquals(first.hashCode(), second.hashCode())
    }

    @Test
    @DisplayName("equals is false & hashCode differs if email address differs")
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void equalsAndHashCode5() {
        // given
        Person first = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
        Person second = new Person(first.name, first.birthday, "tina.acher@rewe-digital.com")

        // expect
        assertFalse(first == second)
        assertFalse(second == first)
        assertNotEquals(first.hashCode(), second.hashCode())
    }

    @Test
    @DisplayName("toString contains all property values")
    void toString1() {
        // given
        Person person = new Person("Tina Acher", today().minusYears(18).plusDays(1), "tina.acher@assertagile.de")

        // when
        String string = person

        // then
        assertTrue(string.contains(person.name))
        assertTrue(string.contains(person.birthday.toString()))
        assertTrue(string.contains(person.emailAddress))
    }
}