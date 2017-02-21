package de.beosign.snakeyamlanno.property;

import de.beosign.snakeyamlanno.annotation.Property;
import de.beosign.snakeyamlanno.convert.GenderConverter;
import de.beosign.snakeyamlanno.convert.LengthToCmConverter;
import de.beosign.snakeyamlanno.type.Animal;

//CHECKSTYLE:OFF

public class Person {
    private String name;
    private int height; // cm
    private Gender gender;

    @Property(ignoreExceptions = true)
    private Animal animal;

    public enum Gender {
        MALE("m"),
        FEMALE("f");

        private String abbr;

        private Gender(String abbr) {
            this.abbr = abbr;
        }

        public String getAbbr() {
            return abbr;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Property(converter = GenderConverter.class)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", height=" + height + ", gender=" + gender + ", animal=" + animal + "]";
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Property(converter = LengthToCmConverter.class)
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}