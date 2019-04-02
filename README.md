# Groovy Workshop

## Differences to Java

While Groovy and Java are quite similar, there are some differences. Some may be obvious, but some are not. Read [Differences with Java] and try the following objectives:

-[ ] Checkout the [`Overloaded` class]. Now add a test, which calls *both* methods to [`JavaTest`] and [`GroovySpec`].
-[ ] Write another test, which tests the content of [`test.txt`] without calling any `close` method explicitly.
-[ ] Checkout the [`Primitives` class]. Add a test, which calls *both* methods to [`JavaTest`] and [`GroovySpec`].
-[ ] Add a test illustrating the behaviour of the `==` operator in Groovy and Java: test two objects for being identical and equal.

[Differences with Java]: <http://groovy-lang.org/differences.html>
[`Overloaded` class]: <src/main/java/de/assertagile/workshop/groovy/Overloaded.java>
[`JavaTest`]: <src/test/java/de/assertagile/workshop/groovy/JavaTest.java>
[`GroovySpec`]: <src/test/groovy/de/assertagile/workshop/groovy/GroovySpec.groovy>
[`test.txt`]: <src/test/resources/test.txt>
[`Primitives` class]: <src/main/java/de/assertagile/workshop/groovy/Primitives.java>
