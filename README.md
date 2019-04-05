# Groovy Workshop

[![Build Status](https://travis-ci.org/mkutz/groovy-workshop.svg?branch=master)](https://travis-ci.org/mkutz/groovy-workshop)

Workshop for [Groovy] programming language with a special focus on Java™ developers.

## Setup

This workshop uses [Gradle] as its build tool. Generally it is also possible to run Groovy via [Maven] (see [Groovy docs on Maven integration]) but [Gradle]'s support for different source sets –e.g. one for Groovy and Java– is very useful for this workshop.

## Part 1: Syntax Differences to Java

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
- [ ] Keeping the [Differences with Java] in mind, make the [`Person` Groovy class] as Groovy as you can. Run the tests after each change.\
  Note that there is a IntelliJ action called "cleanup code".\
  Hint: my solution has only 50 lines of code (keeping white space as is)
- [ ] Now let's move something with more logic over. Turn [`PersonService` Java class] into a Groovy class.
  ```bash
  mv src/main/java/de/assertagile/workshop/groovy/PersonService.java \
     src/main/groovy/de/assertagile/workshop/groovy/PersonService.groovy
  ```
  Try to compile.
- [ ] Fix the compile errors and run the tests.\
  You might want to look at the section about [Lambdas](http://groovy-lang.org/differences.html#_lambdas).
- [ ] Again try to make [`PersonService` Groovy class] truly Groovy.
- [ ] Check the 

## Part 2: Groovy Testing

Now we are going to convert our tests over to the Groovy side.

- [ ] Let's just move the [`PersonTest` Java test] first as we did with the classes before:
  ```bash
  mv src/test/java/de/assertagile/workshop/groovy/PersonTest.java \
     src/test/groovy/de/assertagile/workshop/groovy/PersonTest.groovy
  ```
  Run it and make it Groovy.
- [ ] Now also move [`PersonServiceTest` Java test]:
  ```bash
  mv src/test/java/de/assertagile/workshop/groovy/PersonServiceTest.java \
     src/test/groovy/de/assertagile/workshop/groovy/PersonServiceTest.groovy
  ```
  There will be a compile error. Maybe you can find a creative way to fix that without using a `\` in the [Groovy Style Guide].
- [ ] Try to fix the remaining tests. You might find [the paragraph about Multi-methods](http://groovy-lang.org/differences.html#_multi_methods) pretty useful here.



## Content TODO
- [X] Collection literals
- [ ] Map constructor
- [ ] Named parameters
- [ ] Type conversions
- [ ] String literals
- [ ] Groovy Transform (vs Lombok)
- [ ] XML/JSON Slurper
- [ ] SQL (?)
- [ ] Spock (Teaser)


[Groovy]: <http://www.groovy-lang.org/>
[Gradle]: <https://gradle.org/>
[Maven]: <https://maven.apache.org/>
[Groovy docs on Maven integration]: <http://docs.groovy-lang.org/latest/html/documentation/tools-groovyc.html#_maven_integration>
[Differences with Java]: <http://groovy-lang.org/differences.html>
[Groovy Style Guide]: <http://groovy-lang.org/style-guide.html>
[`Person` Java class]: <src/main/java/de/assertagile/workshop/groovy/Person.java>
[`PersonService` Java class]: <src/main/java/de/assertagile/workshop/groovy/PersonService.java>
[`Person` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
[`PersonService` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
[`PersonTest` Java test]: <src/test/java/de/assertagile/workshop/groovy/PersonTest.java>
[`PersonServiceTest` Java test]: <src/test/java/de/assertagile/workshop/groovy/PersonServiceTest.java>
[`PersonTest` Groovy test]: <src/test/groovy/de/assertagile/workshop/groovy/PersonTest.groovy>
[`PersonServiceTest` Groovy test]: <src/test/groovy/de/assertagile/workshop/groovy/PersonServiceTest.groovy>