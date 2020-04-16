# Java optionals

## What are Optionals and why we should use them in project?

Optionals were added in Java 8 and extended in next versions. Their main purpose is to handle so common NullPointerExceptions in really efficent and clear way. It can sound quite enigmatic and difficult to understand so let's go straight forward to examples.


## How Optional look like?

Optional is a kind of object wrapper and using its method we can check whether object is present or not. Furthermore, we can also perform some action on object wrapped into optional if exists and not only.

```java
Optional<String> optionalName
```


## Creating Optional

We can create Optional from existing object or create just an empty one.

```java
Optional<String> emptyOptional = Optional.empty(); // this optional wraps nothing
```

```java
String s = "java from zero to hero!";

// this optional wraps our String. Notice: value has to be non-null
Optional<String> heroOptional = Optional.of(s); 
```

```java
String s = null;

// some more code here... - setting our String to non-null value or not

// this optional can hold both non-null or null value
Optional<String> maybeNullOptional = Optional.ofNullable(s);
```


## Checking if value in Optional is present or not

There are two ways to check if Optional wraps null or non-null value. We can do this by performing one of following methods:

```java
Optional<String> heroOptional = Optional.of("java from zero to hero!");

// this method check if value is present - in this case it'll return true
heroOptional.isPresent();

// this method check if value is not present - in this case it'll return false
heroOptional.isEmpty();
```


## Getting value from Optional in safe way - default value

The major purpose of using Optionals is avoiding situations like obtaining null instead of desired value and performing action on non-present value, for example. Therefore, using Optional we can set what should be returned if value is not present - kind of default value.

Before we begin, let's say we have two different Optionals - we will use them in next examples:

```java
Optional<String> heroOptional = Optional.of("from zero to hero!");
Optional<String> emptyOptional = Optional.empty();
```

#### orElse()

Using this method, we can set the default value which will be returned if object wrapped in Optional is not present. The default value must be the same type as the type of value in Optional.

```java
// default value
String defaultValue = "default value!";

String hero = heroOptional.orElse(defaultValue); // returns: "from zero to hero"
String anotherHero = emptyOptional.orElse(defaultValue); // returns "default value!"
```

#### orElseGet()

Using this method, we can set how the default value should be obtained if object wrapped in Optional is not present - mostly always is just a function will return the desired default value.

Let's have a method which return our default value:

```java
public String getDefaultValue() {
  return "default value";
}
```

Now we perform orElseGet() method on our optionals:

```java

String hero = heroOptional.orElseGet(getDefaultValue()); // returns: "from zero to hero"
String anotherHero = emptyOptional.orElseGet(getDefaultValue()); // returns "default value!"
```

We can also use reference to our default value method (assuming that it is in the same class in this case - cause we are using `this`):

```java
String hero = heroOptional.orElseGet(this::getDefaultValue); // returns: "from zero to hero"
```

#### orElseThrow()

Using this method, we can make our Optional throw an exception instead of default value if value is not present. By default, Optional will throw `NoSuchElementException` but we can set custom exception to be thrown by passing it as parameter.

```java
String hero = heroOptional.orElseThrow(); // returns "from zero to hero"

String anotherHero = emptyOptional.orElseThrow(); // throws NoSuchElementException
String theOtherHero = emptyOptional.orElseThrow(() -> new NotHeroException()); // throws our custom exception
```

We can also use reference to constructor of custom custom exception:

```java
String theOtherHero = emptyOptional.orElseThrow(NotHeroException::new);
```


## Performing action on value in Optional in safe way

We can also perform actions on our object wrapped in Optional in very safe way - as it was with accessing the value. Optional API provides some methods which we can use when we want to perfom some action if value in Optional is present.

Again. Before we begin, let's say we have two different Optionals - we will use them in next examples:

```java
Optional<String> heroOptional = Optional.of("from zero to hero!");
Optional<String> emptyOptional = Optional.empty();
```

#### ifPresent()

Using this method, we can easily perform some action on an wrapped in Optional object if it is present:

```java

// prints to the console "from zero to hero":
heroOptional.ifPresent(s -> System.out.println(s));

// nothing happen here:
emptyOptional.ifPresent(s -> System.out.println(s));
```

We can also use reference to the method;

```java
heroOptional.ifPresent(System.out::println);
```

#### ifPresentOrElse()

Using this method, we can determine both: the action if value is present, and the other action - if Optional is empty.

```java
// prints to the console "from zero to hero":
heroOptional.ifPresent(s -> System.out.println(s), () -> System.out.println("No hero here :c"));

// prints to the console "No hero here :c":
emptyOptional.ifPresent(s -> System.out.println(s), () -> Systen.out.println("No hero here :c"));
```


## Filtering the Optional:

We will sometimes want to check if we can return the value based on some internal conditions, for example. Instead of writing additional ifs, we can use method provided by Optional API. If value is present and passes the filter, we'll get optional with our value. If not - filter method will return empty Optional.

```java
Optional<String> heroOptional = Optional.of("Hero is here!");
Optional<String> anotherHeroOptional = Optional.of("2nd hero is here!");

heroOptional
  .filter(s -> s.contains("Hero"))
  .isPresent(); // returns true

anotherHeroOptional
  .filter(s -> !s.contains("2nd"))
  .isPresent(); // returns false
```


## Mapping the Optional:

One of the big advantages of using Optionals is easy mapping our value to another without checking explicitly if value is present. To understand how it works and why is much better than without using Optionals, let's check following example.

Assume, that we have simple class `Person` with two fields: `name` and `surname`. Both fields can be null.

```java
public class Person {

  private String name;
  private String surname;
  
  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }
  
  public String getName() {
    return name;
  }
  
  public String getSurname() {
    return surname;
  }

}
```

Now, we want to create a method which gets an `Person` instance and returns name in upper case or return empty string if values are not present. What's really importnant here: we have to check if object given as a parameter is non-null value and then if name is also non-null. Otherwise, we'll get NullPointerException if we perform some action on them.

Let's check how such method would look like without using Optionals.

```java
public String getNameInUpperCase(Person person) {
  if (person != null && person.getName() != null) {
    return person.getName().toUpperCase();
  } else {
    return "";
  }
}
```

We can notice this awful `if` statement. In this example it isn't so bad but imagine `name` field is also object with some other fields which we want to access. Then this `if` would be larger and less readable.

Now, we rewrite this method using Optionals:

```java
public String getNameInUpperCase(Person person) {
  return Optional.ofNullable(person)
    .map(p -> p.getName())
    .map(name -> name.toUpperCase())
    .orElse("");
}
```

Here we can easily inspect our code - line by line, because each of them is responsible for different step in accessing the final value. With Optional API we're sure that we won't get exception as map method converts our value if present or just returns empty optional. In the last step we want to get our value and by using orElse method we set default value if it obtains empty optional from previous map methods.
    


## Bunch of examples

It's really hard to understand anything without practise and checking how it works on our own. Therefore, you can find here a project with a few examples of mentioned methods. Let's check it out!

*Notice: examples are presented using unit tests made with JUnit 5 in project build with Maven*
