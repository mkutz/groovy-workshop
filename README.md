# Groovy Workshop

[![Build Status](https://travis-ci.org/mkutz/groovy-workshop.svg?branch=master)](https://travis-ci.org/mkutz/groovy-workshop)

Workshop for [Groovy] programming language with a special focus on Java™ developers.

## Setup

This workshop uses [Gradle] as its build tool. Generally it is also possible to run Groovy via [Maven] (see [Groovy docs on Maven integration]) but [Gradle]'s support for different source sets –e.g. one for Groovy and Java– is very useful for this workshop.

## Part 1: Main Differences to Java

### Objectives

- [ ] Take a look at the [`Person` Java class] and the [`PersonService` Java class] and run all tests once.
- [ ] Move both from `src/main/java` to `src/main/groovy` and change the filename extension from `.java` to `.groovy`. Run all tests again.

[Groovy]: <http://www.groovy-lang.org/>
[Gradle]: <https://gradle.org/>
[Maven]: <https://maven.apache.org/>
[Groovy docs on Maven integration]: <http://docs.groovy-lang.org/latest/html/documentation/tools-groovyc.html#_maven_integration>
[`Person` Java class]: <src/main/java/de/assertagile/workshop/groovy/Person.java>
[`PersonService` Java class]: <src/main/java/de/assertagile/workshop/groovy/PersonService.java>
[`Person` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
[`PersonService` Groovy class]: <src/main/groovy/de/assertagile/workshop/groovy/Person.groovy>
