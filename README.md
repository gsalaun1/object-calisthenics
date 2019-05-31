# Object Calisthenics

Source : [9 steps to better software design today, by Jeff Bay](https://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)

1. [One level of indentation per method](#rule_1)
2. [Don’t use the ELSE keyword](#rule_2)
3. [Wrap all primitives and Strings](#rule_3)
4. [First class collections](#rule_4)
5. [One dot per line](#rule_5)
6. [Don’t abbreviate](#rule_6)
7. [Keep all entities small (50 lines)](#rule_7)
8. [No classes with more than two instance variables](#rule_8)
9. [No getters/setters/properties](#rule_9)

## 9 rules

### 1. <a id="rule_1">One level of indentation per method</a>

> A giant method lacks cohesiveness.  
&#32;  
Try to ensure that each method does exactly one thing – one control structure, or one block of statements, per method.  
&#32;  
As you work with methods that do exactly one thing, expressed within classes doing exactly one thing, your code begins to change.  
&#32;  
Use the Extract Method feature of your IDE to pull out behaviors until your methods only have one level of indentation

Martin Fowler - [Extract Method](https://refactoring.com/catalog/extractFunction.html)

### 2. <a id="rule_2">Don’t use the ELSE keyword</a>

> Nearly every programmer has seen a nasty nested conditional that’s impossible to follow, or a case statement that goes on for pages.  
&#32;  
Object-oriented languages give us a powerful tool, polymorphism, for handling complex conditional cases.  
&#32;  
Early return  
&#32;  
Try the Null Object pattern

Martin Fowler - [Replace Conditional With Polymorphism](https://refactoring.com/catalog/replaceConditionalWithPolymorphism.html)

Martin Fowler - [Introduce Special Case](https://refactoring.com/catalog/introduceSpecialCase.html)

### 3. <a id="rule_3">Wrap all primitives and Strings</a>

> When a method takes an int as a parameter, the method name needs to do all of the work of expressing the intent. If the same method takes an Hour as a parameter, it’s much easier to see what’s going on

Code smell : [Primitive Obsession](https://refactoring.guru/smells/primitive-obsession)

### 4. <a id="rule_4">First class collections</a>

> Each collection gets wrapped in its own class, so now behaviors related to the collection have a home (filter methods, applying a rule to each element, ...)
     
### 5. <a id="rule_5">One dot per line</a>

> Multiple dots indicate that you’re violating encapsulation.  
&#32;  
Try asking that object to do something for you, rather than poking around its insides.  
&#32;  
Law Of Demeter (“Only talk to your friends”)

### 6. <a id="rule_6">Don’t abbreviate</a>

> Abbreviations can be confusing, and they tend to hide larger problems.  
&#32;  
Why Do You Want To Abbreviate ?  
&#32;  
You write the same name over and over again ? => Code Duplication  
&#32;  
Method name is too long ? Maybe your class has multiple responsibilities

### 7. <a id="rule_7">Keep all entities small (50 lines)</a>

> No class over 50 lines and no package over 10 files.  
&#32;  
Long files are harder to read, harder to understand, and harder to maintain.  
&#32;  
Packages, like classes, should be cohesive and have a purpose. Keeping those packages small forces them to have a real identity.

### 8. <a id="rule_8">No classes with more than two instance variables</a>

> High cohesion, and better encapsulation.  
&#32;  
Leads to very quick decomposition of complex large objects into much simpler models.  
&#32;  
Two kinds of classes, those that maintain the state of a single instance variable, and those that coordinate two separate variables.

### 9. <a id="rule_1">No getters/setters/properties</a>

> Enrich the entity with more valuable and meaningful logic and methods <> anemic domain model/data object  
&#32;  
Dramatic reduction in duplication errors  
&#32;  
Better localization of changes to implement new features  
&#32;  
Getters and setters violate the Open/Closed Principle 

Martin Fowler - [Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)

## Bank kata

Source : [Bank Kata by Sandro Mancuso](https://github.com/sandromancuso/Bank-kata)

Your PO gives you as an acceptance test the following scenario:

> Given a client makes a deposit of 1000 on 10-06-2019  
And a deposit of 2000 on 13-06-2019  
And a withdrawal of 500 on 14-06-2019  
When she prints her bank statement  
Then she would see  

| date       | credit  | debit  | balance |
|------------|---------|--------|---------|
| 14/06/2019 |         | 500.00 | 2500.00 |
| 13/06/2019 | 2000.00 |        | 3000.00 |
| 10/06/2019 | 1000.00 |        | 1000.00 |

Implement this product, guided by tests.
