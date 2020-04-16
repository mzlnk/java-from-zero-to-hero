package pl.mzlnk.javafromzerotohero.optionals.repository;

import pl.mzlnk.javafromzerotohero.optionals.dto.Address;
import pl.mzlnk.javafromzerotohero.optionals.dto.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {

    private Map<Integer, Person> people = new HashMap<>();

    public PersonRepository() {
        people.put(1, new Person(1,"John", "Smith", new Address("New York", "5th Avenue", 1028)));
        people.put(2, new Person(2,"Sally", "Johnson", new Address("New York", "10th Avenue", 2050)));
        people.put(3, new Person(3,"Evan", "Adams", new Address("Washington DC", "Blue Street", 219)));
    }

    public Optional<Person> findById(int id) {
        return Optional.ofNullable(this.people.get(id));
    }

}
