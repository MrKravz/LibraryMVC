package ru.parhom.springcourse.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person
{
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max=15, message = "Name out of range")
    private String name;
    @Max(value = 2004, message = "Некорректно введенный год написания")
    @Min(value = 1700, message = "Некорректно введенный год написания")
    private int yearOfBirthday;

    public Person(){}
    public Person(int id, String name, int yearOfBirthday) {
        this.id = id;
        this.name = name;
        this.yearOfBirthday = yearOfBirthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(int yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }
}
