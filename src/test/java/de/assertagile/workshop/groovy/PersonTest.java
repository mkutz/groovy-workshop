package de.assertagile.workshop.groovy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}