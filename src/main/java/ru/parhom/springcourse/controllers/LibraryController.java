package ru.parhom.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.parhom.springcourse.dao.PersonDao;
import ru.parhom.springcourse.models.Person;
import ru.parhom.springcourse.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/library")
public class LibraryController
{
    private final PersonDao personDao;
    private final PersonValidator personValidator;

    public LibraryController(PersonDao personDao, PersonValidator personValidator) {
        this.personDao = personDao;
        this.personValidator = personValidator;
    }
    @GetMapping()
    public String index(Model model)
    {
        model.addAttribute("people", personDao.index());
        return "library/index";
    }
    @GetMapping("/new")
    public  String newPerson(@ModelAttribute("person") Person person)
    {
        return "library/new";
    }
    @PostMapping()
    public  String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult)
    {
        personValidator.validate(person,bindingResult);
        if (bindingResult.hasErrors())
        {
            return "library/new";
        }
        personDao.save(person);
        return "redirect:/library";
    }
    @GetMapping("/{id}")
    public  String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", personDao.show(id));
        return "library/show";
    }
    @GetMapping ("/{id}/edit")
    public  String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("person", personDao.show(id));
        return "library/edit";
    }
    @PatchMapping ("/{id}")
    public  String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult ,@PathVariable("id") int id)
    {
        if (bindingResult.hasErrors())
        {
            return "library/edit";
        }
        personDao.update(id, person);
        return "redirect:/library";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") int id)
    {
        personDao.delete(id);
        return "redirect:/library";
    }
}
