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
