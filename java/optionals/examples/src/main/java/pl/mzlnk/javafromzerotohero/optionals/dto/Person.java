package pl.mzlnk.javafromzerotohero.optionals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private String surname;
    private Address address;

}
