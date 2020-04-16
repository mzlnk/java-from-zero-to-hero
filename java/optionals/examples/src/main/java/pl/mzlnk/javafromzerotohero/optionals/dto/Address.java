package pl.mzlnk.javafromzerotohero.optionals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private int streetNumber;

}
