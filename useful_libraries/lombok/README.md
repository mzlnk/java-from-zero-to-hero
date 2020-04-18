# Project Lombok - essential library in everyday coding

Project Lombok is Java library which every developer should know. It helps us to avoid writing lots of code which is obviously neccessary in our projects but not the most important - like getters, setter, toString() methods and not only. What does it mean? It means than Lombok can do this stuff automatically and we don't have to write such basic methods on our own - we just tell Lombok where we need them. How? By simple annotations provided in API. Sounds interesting? Let's check out how it works!

Link to Project Lombok website: [click here](https://projectlombok.org "project lombok")

---

### How to add Lombok to our project?

If you have a Maven project, you have to simply add another dependency in your `pom.xml` file. Library is on MVN Repository, so you can just type in Google *lombok maven dependency* and it will easily find proper link in search results. You can also paste the following code with the currently latest version of Lombok:

```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
    <scope>provided</scope>
</dependency>
```

**Hovewer, it is not only one thing to do, if you want to use Lombok in your project**

You have to also enable annotation preprocessing in your project and add plugin to your IDE if you want your IDE properly highlight your code and give you hint while developing your project.

For IntelliJ IDEA:

I'm using IntelliJ IDEA as an IDE, so these are steps you have to follow to properly setup everything before you use Lombok:

- enable *Annotation Processing*. You can do this by opening Settings (*File->Settings*). Then you have to go to *Build, Execution, Deployment* section and then choose *Annotation Processors*. Finally find checkbox labeled *Enable annotation processing* and make a tick on it.

- install Lombok plugin for IntelliJ IDEA. You can also do this by opening Settings (*File->Settings*). Then go to *Plugins* section and find in Marketplace plugin called *Lombok*. Last step is install it and restart IDE.


*For other IDEs you have to check proper setup instructions in the Internet. The easiest way to find them is just go to the main page of Project Lombok and find detailed instructions for your IDE in "install" section*
  
---

### How to use Lombok in our project?

Using Lombok is so simple and intuitive. Whole concept is based on using annotations in places where you want to add some code. It's quite hard to describe it but if you look on the next few examples, you'll know how it all works.

---

### Getters and setters:

If you want to generate getters or setter for a field in your class, you have to just add `@Getter` or `@Setter` annotation next to this field.

```java
public class Person {

    @Getter
    private String name;
    
    @Getter
    @Setter
    private String surname;
  
}
```

The code above will generate in our `Person` class the following methods: `getName()`, `getSurname()` and `setSurname(String surname)`.

The naming convetion of generated methods is really simple:

- getter will have structure `get` + `field name` or `is` + `field name` for boolean fields. Such methods won't have any parameters and their return type will be the same as the type of the annotated field

- setter will look very similar: `set` + `field name`. Such methods' type is `void` and they have one paramater with the same type as annotated field (value passed as parameter will be assigned to the field)

We can also annotate whole class by `@Getter` or `@Setter` annotation and it will generate getters and setter for all fields in our class.

```java
@Getter
public class Person {
    
    private String name;
    private String surname;
  
}
```

Both `name` and `surname` fields will have generated both setters and getters in this case.

What's more, we can also determine the accesibilty of generated method. If we want e.g. protected access getter, we need to add just `AccessLevel` parameter to our annotation.

```java
public class Person {
    
    @Getter(AccessLevel.PROTECTED)
    private String name;
  
}
```

Available access levels:
- `PUBLIC` - generate method with public access
- `PACKAGE` - generate method with package visibility
- `PRIVATE` - generate method with private access
- `NONE` - generate nothing (useful if we want to generate getter for all fields instead of one - then you need to just add annotation on class and then additional annotation with this access level to a field to exclude)

---

### Constructors:

We can automatically generate constructors using on of three available annotations: `@NoArgsConstructor`, `@AllArgsConstructor` or `@RequiredConstructor`.

#### `@NoArgsConstructor`:

The name of annotation has already told us where we can use it and how it works. This annotation generate constructor with no arguments as paramaters. It means that all fields in class will be set to their default values.

```java
@NoArgsConstructor
public class Person {

    private String name;
    private String surname;
  
}
```

The code above will generate for us the no paramter constructor, so in other place in our project we'll be able to use it in the following way:

```java
Person person = new Person();
```


#### `@AllArgsConstructor`:

Second type of "constructor making" annotation is `@AllArgsConstructor`. If we use it in our class, Lombok generate constructor with the same amount of paramaters as amount of fields in the class. It means that we'll be able to set value to every field in the class by using this constructor.

```java
@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    
}
```
 Then we will have access to the following constructor:
 
 ```java
 Person person = new Person("John", "Smiths");
 ```
 
 Where `"John"` will be set to field `name` and `"Smiths"` will be set to field `surname` in `Person` object.


#### `@RequiredConstructor`

Sometimes we will want to make kind of *factory* static method which allow us to create new instances of class. `@RequiredConstructor` is annotation which generate such a method. Let's see how it works.

```java
@RequiredConstructor(staticName = "of")
public class Person {

    @NonNull
    private String name;
    
    private final String surname;
    
    private int age;
    
}
```

Then we'll be able to create new `Person` objects in following way:

```java
Person person = Person.of("John", "Smiths");
```

We can notice that not every field has its parameter in generated method. How it works? Really simple - only fields with final modifier or annotated as `@NonNull` will have its paramater in generated constructor by `@RequiredConstructor` annotation.

We can also notice that our `@ReuqiredConstructor` has its parameter - `staticName`. We can change name of our factory method using this paramater. In our case, we set this paramater to `of` and that's why Lombok generated static method `Person.of()` for us.

---

### toString() won't be any problem any more

Project Lombok also provides `@ToString` annotation. If we add this annotation to our class, Lombok will generate the implementation of `toString()` method. By default, the string returned by this method consist of class name and all included fields.

```java
@ToString
@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    
}
```

Then, if we invoke `toString()` method on an instance of Person class we will give such an output (to the console, for example):

```java
Person person = new Person("John", "Smiths");
System.out.println(person);
```

The result in the console:
```text
Person(name=John, surname=Smiths
```

#### `@ToString.Include`, `@ToString.Exclude`:

We can also tell Lombok, which fields we want to include or exclude in our `toString()` method. This can be done by adding one of these annotations: `@ToString.Include` or `@ToString.Exclude`. Let's see, how it works:

```java
@ToString
public class Person {

    private String name;
    private String surname;
    
    @ToString.Exclude
    private String age;
    
}
```

The, if we invoke `toString()` method on an instance of `Person` class defined above, we'll get information about both `name` and `surname` values but the field `age` won't be visible.


```java
@ToString(onlyExplicitlyIncluded = true)
public class Person {

    @ToString.Include
    private String name;
    
    private String surname;
    private int age;
}
```

Here, we defined another version of our `Person` class. However, now we tell Lombok, which fields should be included - using `@ToString.Include` annotation. We can also notice that we have to add additional parameter to our `@ToString` annotation - `onlyExplicitlyIncluded` and set it to `true`. It is important cause we want to explicitly include some fields.

---

### `equals()` and `hashCode()` methods:

Lombok provides another useful annotation: `@EqualsAndHashCode`. It generates in our class implementations of `equals()` and `hashCode()` methods based on fields in the class.

```java
@EqualsAndHashCode
public class Person {

    private String name;
    private String surname;
    
}
```

Then, if we invoke `equals()` method to compare two instances of `Person` class, the generated by Lombok implementation of the method will check if both objects has the same type, etc. (like the default implementation pattern which can be found in tutorial, docs, etc.). Apart from the default checks, `equals()` method will also check if fields `name` and `surname` are equal.

On the other hand, when we invoke `hashCode()` method, we will get hash based on values stored in fields in our class - in this case: in fields `name` and `surname`. The generated by Lombok implementation also refers to good practises in creating proper `hashCode()` method implementation - it's based on calculation on primary numbers;

If we don't want to include some fields to checking in `equals()` or `hashCode()` method, we can add another helper annotation - `@EqualsAndHashCode.Inlude` or `@EqualsAndHashCode.Exclude` - to fields which you want to include/exclude. Here's the simple example:

```java
@EqualsAndHashCode
public class Person {

    private String name;
    private String surname;
    
    @EqualsAndHashCode.Exclude
    private int age;
 
}
```

Notice: if we want to explicitly include some fields, we have to do the same thing as we've done when explicitly including fields in `toString()` - we have to add additional parameter to our annotation: `@EqualsAndHashCode(onlyExplicitlyIncluded = true)`.

```java
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

    @EqualsAndHashCode.Include
    private String name;
    
    @EqualsAndHashCode.Include
    private String surname;
    
    private int age;
    
}
```

---

### Implment Builder pattern just in one line.

The `@Builder` annotation produces complex builder APIs for your classes, as we can read in Project Lombok docs. What does it mean? It means that you no longer have to writer builder pattern implementation in your project for your own. If you're not familiar with builder pattern, check article about design patterns [here](https://github.com/mzlnk/java-from-zero-to-hero "design patterns").

So, let's move straight forward to our example how `@Builder` annotation works:

```java
@Builder
public class Person {

    private String name;
    private String surname;
    private int age;
    
}
```

Then, if we want to create an instance of our `Person` class, we can use generated by Lombok `PersonBuilder` inner class.

```java
Person person = Person.builder()
    .name("John")
    .surname("Smiths")
    .age(25)
    .build();
```

#### Builder and collections - `@Singular` annotation

If we have in our class field which represents a collection and we want to add some values to it by using builder from Lombok, we have to annotate such field with `@Signular` annotation. Then two methods will e generated instead of previous setter method which just set the value to the field. The first one will add passed value as parameter to the collection, the second method will add all elements in collection passed as a parameter. It can be quite not understandable, so let's look at the following example.

```java
@Builder
public class Shop {

    @Singular
    private List<Product> products;
    
}
```

Then we can build our `Shop` with builder in the following way:

```java
List<Product> moreProducts = Arrays.asList(new Product("Tomato"), new Product("Cucumber"));

Shop shop = Shop.builder()
    .product(new Product("Apple"))
    .product(new Product("Grapes"))
    .product(new Product("Banana"))
    .products(moreProducts)
    .build();
```

With such *building* code, we'll have in our `Shop` all products - Apple, Grapes, Banana, Tomato, Cucumber. Notice, that now we didn't override previously existing values but just add new ones to the `products` collection.


