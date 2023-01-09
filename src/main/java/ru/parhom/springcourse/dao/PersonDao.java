package ru.parhom.springcourse.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.parhom.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;


    public PersonDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, yearofbirthday) VALUES (?, ?)", person.getName(), person.getYearOfBirthday());
    }
    public void update(int id,  Person person) {
        jdbcTemplate.update("UPDATE person SET name=?, yearofbirthday=? WHERE id=?", person.getName(), person.getYearOfBirthday(), id);
    }
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream()
                .findAny().orElse(null);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
