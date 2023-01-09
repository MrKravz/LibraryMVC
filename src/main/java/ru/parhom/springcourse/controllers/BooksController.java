package ru.parhom.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.parhom.springcourse.dao.BookDao;
import ru.parhom.springcourse.dao.PersonDao;
import ru.parhom.springcourse.models.Book;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController
{
    private final BookDao bookDao;

    public BooksController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping()
    public String index(Model model)
    {
        List<Book> books = bookDao.index();
        model.addAttribute("books", books);
        return "books/index";
    }
}
