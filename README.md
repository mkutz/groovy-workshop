# Groovy Workshop

[![Build Status](https://travis-ci.org/mkutz/groovy-workshop.svg?branch=master)](https://travis-ci.org/mkutz/groovy-workshop)

Workshop for [Groovy] programming language with a special focus on Java™ developers.

## Setup

This workshop uses [Gradle] as its build tool. Generally it is also possible to run Groovy via [Maven] (see [Groovy docs on Maven integration]) but [Gradle]'s support for different source sets –e.g. one for Groovy and Java– is very useful for this workshop.

## Part 1: Main Differences to Java

In this part we'll try to convert a Plain Old Java Object (POJO) into a Plain Old Groovy Object (POGO) to find the most basic differences between Java and Groovy.

All answers you might be looking for can be found in the [Differences with Java] (and the [Groovy Style Guide]).

### Objectives

- [ ] Take a look at the project, especially at [`Person` Java class]. Try to run the tests:
  ```bash
  ./gradlew test
  ```
- [ ] Let's turn the [`Person` Java class] into a Groovy class. Just move it from `src/main/java` to `src/main/groovy` and change the filename extension from `.java` to `.groovy`
  ```bash
  mv src/main/java/de/assertagile/workshop/groovy/Person.java \
     src/main/groovy/de/assertagile/workshop/groovy/Person.groovy
  ```
  Run the tests again.
- [ ] Understand & fix the error. You might want to read the [Behaviour of `==`](http://groovy-lang.org/differences.html#_behaviour_of_code_code) again.
- [ ] Keeping the [Differences with Java] in mind, make the [`Person` Groovy class] as Groovy as you can. Run the tests after each change. 

[Groovy]: <http://www.groovy-lang.org/>
[Gradle]: <https://gradle.org/>
[Maven]: <https://maven.apache.org/>
[Groovy docs on Maven integration]: <http://docs.groovy-lang.org/latest/html/documentation/tools-groovyc.html#_maven_integration>
[Differnces with Java]: <http://groovy-lang.org/differences.html>
[Groovy Style Guide]: <http://groovy-lang.org/style-guide.html>
[`Person` Java class]: <src/main/java/de/assertagile/workshop/groovy/Person.java>
[`PersonService` Java class]: <src/main/java/de/assertagile/workshop/groovy/PersonService.java>
[`Person` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
[`PersonService` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
