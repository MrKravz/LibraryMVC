package ru.parhom.springcourse.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Optional;

public class Book
{
    private int id;
   /* @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 25, message = "Некорректно введенное имя книги")*/
    private String name;
  /*  @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 15, message = "Некорректно введенное имя автора")*/
    private String author;
  /*  @Max(value = 2022, message = "Некорректно введенный год написания")
    @Min(value = 1800, message = "Некорректно введенный год написания")*/
    private int yearOfFoundation;
    private int ownerId;
    public Book() {
    }
    public Book(int id, String name, String author, int yearOfFoundation, int ownerId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfFoundation = yearOfFoundation;
        this.ownerId = ownerId;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
