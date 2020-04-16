package pl.mzlnk.javafromzerotohero.optionals.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.mzlnk.javafromzerotohero.optionals.dto.Person;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    static PersonRepository repository;

    @BeforeAll
    static void setUp() {
        repository = new PersonRepository();
    }

    @Test
    void isPresentTest() {
        Optional<Person> personOptional = repository.findById(1); // exists in repository
        Optional<Person> anotherPersonOptional = repository.findById(100); // not exist in repository

        assertTrue(personOptional.isPresent()); // should return true
        assertFalse(anotherPersonOptional.isPresent()); // should return false
    }

    @Test
    void isEmptyTest() {
        Optional<Person> personOptional = repository.findById(1); // exists in repository
        Optional<Person> anotherPersonOptional = repository.findById(100); // not exist in repository

        assertFalse(personOptional.isEmpty()); // should return false
        assertTrue(anotherPersonOptional.isEmpty()); // should return true
    }

    @Test
    void ofTest() {
        String s = "from zero to hero!";
        Optional<String> optional = Optional.of(s);

        // print optional:
        System.out.println(optional.toString());
    }

    @Test()
    void ofNullableTest() {
        String empty = null;

        // it throws exception as Optional.of require non-null value
        assertThrows(NullPointerException.class, () -> Optional.of(empty));

        // we have to use Optional.ofNullable() instead
        Optional.ofNullable(empty);
    }

    @Test
    void orElseTest() {
        Optional<String> heroOptional = Optional.of("from zero to hero!");
        Optional<String> emptyOptional = Optional.empty();

        assertEquals("no hero here :c", emptyOptional.orElse("no hero here :c"));
        assertNotEquals("no hero here :c", heroOptional.orElse("no hero here :c"));
    }

    @Test
    void orElseGetTest() {
        Person p = repository
                .findById(100) // not exist in repository
                .orElseGet(() -> new Person(0, "?", "?", null));

        // we'll see default person printed to the console
        System.out.println(p.toString());
    }

    @Test
    void orElseThrowTest() {
        // we'll throw our custom exception:
        assertThrows(PersonNotFoundException.class, () -> repository.findById(100).orElseThrow(PersonNotFoundException::new));
    }

    @Test
    void ifPresentTest() {
        // we'll print person to the console if given ID exists in our repository
        repository
                .findById(1) // exists in repository
                .ifPresent(person -> System.out.println(person));

        repository
                .findById(100) // not exist in repository
                .ifPresent(person -> System.out.println(person));
    }

    @Test
    void ifPresentOrElse() {
        // we'll print person to the console or print 'ID not found' if person with given ID is not in our repository

        repository
                .findById(1) // exists in repository
                .ifPresentOrElse(System.out::println, () -> System.out.println("ID not found :c"));

        repository
                .findById(100) // not exist in repository
                .ifPresentOrElse(System.out::println, () -> System.out.println("ID not found :c"));
    }

    @Test
    void filterTest() {
        Optional<String> heroOptional = Optional.of("Hero is here!");
        Optional<String> anotherHeroOptional = Optional.of("2nd hero is here!");

        // returns true
        boolean heroPresent = heroOptional
                .filter(s -> s.contains("Hero"))
                .isPresent();

        // returns false
        boolean anotherHeroPresent = anotherHeroOptional
                .filter(s -> !s.contains("2nd"))
                .isPresent();

        // check it:
        assertTrue(heroPresent);
        assertFalse(anotherHeroPresent);
    }

    @Test
    void mapTest() {
        String city = repository
                .findById(1)
                .map(person -> person.getAddress())
                .map(address -> address.getCity())
                .map(s -> s.toLowerCase())
                .orElse("");

        assertEquals("new york", city);
    }

}