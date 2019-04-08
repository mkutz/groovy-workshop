package de.assertagile.workshop.groovy

import java.time.LocalDate

public class Person {

    private final String name;
    private final LocalDate birthday;
    private String emailAddress;

    public Person(String name, LocalDate birthday, String emailAddress) {
        this(name, birthday);
        this.emailAddress = emailAddress;
    }

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isOfAge() {
        return !LocalDate.now().minusYears(18).isBefore(birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this.is(o)) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return name.equals(that.name) &&
                birthday.equals(that.birthday) &&
                Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, emailAddress);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
