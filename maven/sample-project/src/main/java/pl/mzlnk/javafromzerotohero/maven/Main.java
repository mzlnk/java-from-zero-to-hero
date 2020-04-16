package pl.mzlnk.javafromzerotohero.maven;

import lombok.Getter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Your first project build with Maven!");
        System.out.println("Let's check if first dependency works - Project Lombok...");
        System.out.println(Getter.class.toString());
    }

}
