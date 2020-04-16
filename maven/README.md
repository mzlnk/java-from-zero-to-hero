# Build your projects with Maven

### What Maven actually is?

Maven is a build tool which can help us to easily build more complex Java projects.

---
### How Maven works?

Maven works in three cycles called `lifcycle`:
- `clean`
- `site`
- `default`

#### `clean` cycle:

This lifecycle is responsible for cleaning our project from previous result like compiled classes, generated additional files during compilation, jar files, etc.

#### `site` cycle:

This lifcycle creates documentation for our project.

#### `default` cycle:

This cycle is probably the most important beacuse it is responsible for building our project - compiling source files, run tests, etc.

It is also divided into parts called `phases`:

- `validate` - checking project integrity
- `compile` - compiling source files
- `test` - run tests (e.g. written in JUnit)
- `package` - packaging compiled files into `jar` or `war` file (e.g. we're creating library, so we need packed it in one place)
- `integration-test`
- `verify` - veryfing if our package is corrent
- `install` - installing our package (e.g. `jar` file) in local repository (e.g. to use it in other projects)
- `deploy` - publishing our package in remote repository

Phases are run in presented order. It means, running `package` phase make Maven run also previous phases (in this case: `validate`, `compile` and `test`).

In order to run maven cycles or several phases, just run proper command in command propmpt in project directory. Here are some sample commands:
- `mvn clean`
- `mvn package`
- `mvn clean package`

---
### Tell Maven how to build project - `pom.xml`:

`pom.xml` is the file, which determinates how our project should be built - e.g. if tests will run, how we package our project, etc.

#### `pom.xml` for sample project:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>pl.mzlnk</groupId>
    <artifactId>MavenProject</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <name>Maven Project</name>
    <url>https://github.com/BIT-Java/java-maven</url>
    
    <build>
        <!-- describe how project should be built -->
    </build>
    
    <repositories>
        <!-- add custom repositories where dependencies are from -->
    </repositories>

    <dependencies>
        <!-- add dependencies here -->
    </dependencies>

</project>
```

* `<groupId>` - owner's id - usually reversed domain name (**required**)
* `<artifacfId>` - project id (**required**)
* `<version>` - project version (**required**)
* `<packaging>` - packaging mode - e.g. packaging to `jar`
* `<name>` - project display name
* `<url>` - link to project website
* `<build>` - place in which we define the way how the project should be built (by adding proper plugins, for example)
* `<repositories>` - place in which we can add remote repositories where libraries used in project should be downloaded from miejsce
* `<dependencies>` - place in which we can add libraries used in our project (e.g JUnit, Project Lombok, etc.)

#### sample `<repositories>` structure:

```xml
<repositories>
    <repository>
        <id>repository-id</id>
        <url>https://example.com/repo</url>
    </repository>
</repositories>
```

#### sample `<dependencies>` structure:

```xml
<dependencies>
    <dependency>
        <groupId>pl.mzlnk</groupId>
        <artifactId>FileUtil</artifactId>
        <version>1.14</version>
    </dependency>
</dependencies>
```

---
### Building project - `<build>`:

```xml
<build>
    <finalName>JavaMavenExample</finalName>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>13</source>
                <target>13</target>
            </configuration>
        </plugin>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>pl.mzlnk.bitjava.mavenproject.Main</mainClass>
                    </manifest>
                </archive>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
                <appendAssemblyId>false</appendAssemblyId>
            </configuration>
        </plugin>
    </plugins>
</build>
```

First plugin - `maven-compiler-plugin` allows us to determine how compilation process will look like. In this examplem we're defining Java version which should be used to compile source files.

Second plugin provides configuration for packaging compiled files into `jar` file. For example, this plugin allows us to determine if we want to package our project with all *dependencies* to make a standalone app or to point to class which our app should start from.

In this case, if we want to build project with all dependencies using this plugin we have to run following command:

`mvn clean compile assembly:single`

---

### JUnit + Maven

If we want to write unit tests in JUnit in project built with Maven we have to follow a few simple steps:

1) add proper JUnit as dependency - in this case `junit-jupiter-params` and `junit-jupiter-engine` (the second dependency is essential to run JUnit properly)
2) add plugin `maven-surefire-plugin` in `<build>` section

You can find the newest version of dependencies here:
- [JUnit Jupiter Params](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params)
- [JUnit Jupiter Engine](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)
- [Maven Surefire Plugin](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin)

Your `pom.xml` should look like the following one:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M1</version>
        </plugin>
    </plugins>
 </build>

<dependencies>
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

### More about dependencies:

One of the biggest advantage of using Maven is the fact that attaching external libraries is so simple and you don't have to do it every time you pull project from Git - just because you're defining everything in `pom.xml` which is part of the project and everytime all the mysterious stuff is done based on just this file (by Maven, of course).

Let's have a look what a sample `<dependency>` look like:

```xml
<dependency>
  <groupId>pl.mzlnk</groupId>
  <atrifactId>HeroLibrary</artifactId>
  <version>2.0.0</version>
</dependency>
```

* `groupId` - library owner ID - usually reversed domain name
* `artifactId` - library ID - usually name connected with library name
* `version` - version of the library


Maven is so popular build tool that you can easily find common libraries which you can add them as a dependency to your project.

[MVN Repository](https://mvnrepository.com/) is one of the websites you should always have in your mind. You can find lots of essentials and useful libraries there and easily attach them to your project - just choose desired library and copy generated `<dependency>` code to your `pom.xml`.
