# Object Calisthenics

Source : [9 steps to better software design today, by Jeff Bay](https://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)

## 9 rules

1. One level of indentation per method

> A giant method lacks cohesiveness

> Try to ensure that each method does exactly one thing – one control structure, or one block of statements, per method. 

> As you work with methods that do exactly one thing, expressed within classes doing exactly one thing, your code begins to change. 

Tip :

> Use the Extract Method feature of your IDE to pull out behaviors until your methods only have one level of indentation

Martin Fowler - [Extract Method](https://refactoring.com/catalog/extractFunction.html)

2. Don’t use the ELSE keyword

> Nearly every programmer has seen a nasty nested conditional that’s impossible to follow, or a case statement that goes on for pages. 

Tips :

> Object-oriented languages give us a powerful tool, polymorphism, for handling complex conditional cases.

Martin Fowler - [Replace Conditional With Polymorphism](https://refactoring.com/catalog/replaceConditionalWithPolymorphism.html)

> Early return

> Try the Null Object pattern

Martin Fowler - [Introduce Special Case](https://refactoring.com/catalog/introduceSpecialCase.html)

3. Wrap all primitives and Strings

> When a method takes an int as a parameter, the method name needs to do all of the work of expressing the intent. If the same method takes an Hour as a parameter, it’s much easier to see what’s going on

Code smell : [Primitive Obsession](https://refactoring.guru/smells/primitive-obsession)

4. First class collections

> Each collection gets wrapped in its own class, so now behaviors related to the collection have a home (filter methods, applying a rule to each element, ...)
     
5. One dot per line

> Multiple dots indicate that you’re violating encapsulation. Try asking that object to do something for you, rather than poking around its insides. 

> Try asking that object to do something for you, rather than poking around its insides. 

> Law Of Demeter (“Only talk to your friends”)

6. Don’t abbreviate

> Abbreviations can be confusing, and they tend to hide larger problems.

> Why Do You Want To Abbreviate ?

> You write the same name over and over again ? => Code Duplication

> Method name is too long ? Maybe your class has multiple responsibilities

7. Keep all entities small (50 lines)

> No class over 50 lines and no package over 10 files

> Long files are harder to read, harder to understand, and harder to maintain.

> Packages, like classes, should be cohesive and have a purpose. Keeping those packages small forces them to have a real identity.

8. No classes with more than two instance variables

> High cohesion, and better encapsulation.

> Leads to very quick decomposition of complex large objects into much simpler models. 

> Two kinds of classes, those that maintain the state of a single instance variable, and those that coordinate two separate variables.

9. No getters/setters/properties

> Enrich the entity with more valuable and meaningful logic and methods <> anemic domain model/data object

> Dramatic reduction in duplication errors

> Better localization of changes to implement new features.

> Getters and setters violate the Open/Closed Principle 

Tips 

Martin Fowler - [Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)

## Bank kata

http://kata-log.rocks/banking-kata

https://github.com/arolla/bank-kata

Write a class Account that offers the following methods void deposit(int) void withdraw(int) String printStatement()

An example statement would be:

Date        Amount  Balance
24.12.2015   +500      500
23.8.2016    -100      400
