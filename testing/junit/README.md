# Unit tests with JUnit 5

JUnit 5 is one of the probably most popular libraries for writing tests in Java projects. Let's check how it all works and what should we know to write clean and efficient tests.

---

### How to add JUnit 5 to our project?

Let's say we build we have project built with Maven. Then you have to do two following things:

* JUnit as dependency - in this case junit-jupiter-params and junit-jupiter-engine (the second dependency is essential to run JUnit properly)
* add plugin maven-surefire-plugin in `<build>` section

You can find the newest version of dependencies here:

JUnit Jupiter Params
JUnit Jupiter Engine
Maven Surefire Plugin

Your `<build>` and `<dependencies>` sections in `pom.xml` should look like the following ones:

```xml
<build>
    <plugins>
        
        <!-- some other plugins -->
      
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M1</version>
        </plugin>
    </plugins>
</build>
```

```xml
<dependencies>
    
    <!-- some other dependencies -->
  
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.6.0-M1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.6.0-M1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

### Let's prepare some code to test first

First of all, let's assume we want to test our recently written so complicated and advanced class which represents calculator. Let's see what's inside the class and what methods provides.

```java
public class HeroCalculator {

    private int currentValue;
    
    public HeroCalculator(int initValue) {
        this.value = initValue;
    }
    
    public HeroCalculator add(int value) {
        this.currentValue += value;
        return this;
    }
    
    public HeroCalculator subtract(int value) {
        this.currentValue -= value;
        return this;
    }
    
    public HeroCalculator multiply(int value) {
        this.currentValue *= value;
        return this;
    }
    
    public HeroCalculator divide(int value) {
        if (value == 0) {
            throw new RuntimeException("It's Hero Calculator but you cannot divide by zero!");
        }
        this.currentValue /= value;
        return this;
    }
    
    public boolean isNegative() {
        return currentValue < 0;
    }
    
    public boolean isPositive() {
        return currentValue() > 0;
    }
    
    public int getValue() {
        return currentValue;
    }
    
}
```

As we can see it's a simple calculator implementation which provides some basic operations: addition, subtraction, multiplication and division. We'll use it in all further examples.

---

### Where we should put our tests?

If you develop project built with Maven, all your test classes (they consist of test methods) are placed in `src/test/java`. 

You can create test classes inside this directory like normal classes but - especially if you work with IntelliJ IDEA - you can automatically generate test classes and methodes:

* open class with code to test
* click right on the desired class or method name (important: in editor, not in project structure)
* choose `Generate...->Test...`. 
* the popup window with some options will appear - there you'll be able to choose testing library (JUnit 5 in our case) or methods which you want to generate tests for

Now you know how to create test classes. Let's learn how to write our tests!

---

### Writing first test

The easiest way to show how the simple test look like is provide an example and discuss it. Therefore, let's see how such an example look like:

```java
class CalculatorTest {

    @Test
    void calculatorAddTest() {
        Calculator calculator = new Calculator(2);
        calculator.add(5);
        
        assertEquals(7, calculator.getValue());
    }
    
}
```

First of all, we can see that all test methods are placed in tests classes and each of them are annotated with `@Test`. In test methods we can write like in normal method - using all features provided by Java and attached libraries.

The last line our test method is really important and do the *test* stuff - `assertEquals()`. It's one of the method provided by JUnit. It checks if expected value (in our case: `7`) is equal to the actual one (in our case the result of adding 5 to 2 in calculator and got by invoking `calculator.getValue()`). If values are not equal the method throws `AssertionError` which will be handled by JUnit and we'll see the error with all details in the console.

---

### Useful methods to make assertions

`assertEquals()` is not only one method we can use to test our code. JUnit provides plenty of them, so let's check some of them - how they look like and how they work.

#### `assertNotEquals()`

This method takes two paramaters - expected value and the actual one - and it just check if values are not equal (unlike the previous method - `assertEquals()`).

```java
@Test
void calculatorAddTest() {
    Calculator calculator = new Calculator(2);
    calculator.add(2);
    
    assertNotEquals(3, calculator.getValue());
}
```

#### `assertTrue()`

This method checks if condition passed as a parameter is `true`.

```java
@Test
void calculatorTest() {
    Calculator calculator = new Calculator(5);
    
    assertTrue(calculator.isPositive());
}
```

#### `assertFalse()`

This method checks if condition passed as a parameter is `false`.

```java
@Test
void calculatorTest() {
    Calculator calculator = new Calculator(5);
    
    assertFalse(calculator.isNegative());
}
```

#### `assertArrayEquals()`

This method checks if two arrays passed as paramaters are equal.

```java
@Test
void arrayTest() {
    int[] array = new int[3] {5, 67, -4};
    int[] anotherArray = new int[3] {5, 67, -4};
    
    assertArrayEquals(array, anotherArray);
}
```

#### `assertNull()`

This method checks if value is null.
 
 ```java
 @Test
 void nullTest() {
    String someString = null;
    
    assertNull(someString);
}
```

#### `assertNotNull()`

This method checks if value is not null.

```java
void notNullTest() {
    String hero = "Java Hero!";
    
    assertNotNull(hero);
}
```

#### `assertThrows()`

This method takes two parameters. First argument is the type of the exception which should be thrown. The second one is `Runnable` action which we except throwing an exception.

```java
@Test
void divisionTest() {
    Calculator calculator = new Calculator(2);
    
    assertThrows(
        RuntimeException.class, 
        () -> calculator.divide(0) // we cannot divide by zero, so it should throw an exception
    );
}
```

#### more useful methods

These are the most commonly used methods to test code in our project. However, JUnit provides some more of them. You can always check them out by reading JUnit Java Docs which you can find [here](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html "junit docs - assertions")

---

### Preparing environment for testing


