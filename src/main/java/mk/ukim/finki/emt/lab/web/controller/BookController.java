//package mk.ukim.finki.emt.lab.web.controller;
//
//import mk.ukim.finki.emt.lab.model.Author;
//import mk.ukim.finki.emt.lab.model.Book;
//import mk.ukim.finki.emt.lab.model.Country;
//import mk.ukim.finki.emt.lab.model.enumerations.Category;
//import mk.ukim.finki.emt.lab.service.AuthorService;
//import mk.ukim.finki.emt.lab.service.BookService;
//import mk.ukim.finki.emt.lab.service.CountryService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Controller
//@RequestMapping(value = {"/", "/books"})
//public class BookController {
//
//    private final BookService bookService;
//    private final AuthorService authorService;
//    private final CountryService countryService;
//
//    public BookController(BookService bookService, AuthorService authorService, CountryService countryService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.countryService = countryService;
//    }
//
//
//    @GetMapping
//    public String getBookPage(Model model) {
//        List<Book> books = this.bookService.findAll();
//        model.addAttribute("books", books);
//        return "books";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteBook(@PathVariable Long id) {
//        this.bookService.deleteById(id);
//        return "redirect:/books";
//    }
//
//    @GetMapping("/edit-form/{id}")
//    public String editBookPage(@PathVariable Long id, Model model) {
//        if (this.bookService.findById(id).isPresent()) {
//            Book book = this.bookService.findById(id).get();
//            List<Author> authors = this.authorService.findAll();
//            List<Country> countries = this.countryService.findAll();
//            model.addAttribute("authors", authors);
//            model.addAttribute("categories", Category.values());
//            model.addAttribute("countries", countries);
//            model.addAttribute("book", book);
//            return "add-book";
//        }
//        return "redirect:/products?error=ProductNotFound";
//    }
//
//    @GetMapping("/add-form")
//    public String addBookPage(Model model) {
//        List<Author> authors = this.authorService.findAll();
//        List<Country> countries = this.countryService.findAll();
//        model.addAttribute("authors", authors);
//        model.addAttribute("categories", Category.values());
//        model.addAttribute("countries", countries);
//        return "add-book";
//    }
//
//    @PostMapping("/add")
//    public String saveBook(
//            @RequestParam(required = false) Long id,
//            @RequestParam String name,
//            @RequestParam Category category,
//            @RequestParam Long authorId,
//            @RequestParam Integer availableCopies) {
//        if (id != null) {
//            this.bookService.edit(id,name,category,authorId, availableCopies);
//        } else {
//            this.bookService.save(name, category, authorId, availableCopies);
//        }
//        return "redirect:/books";
//    }
//
//    @PostMapping("/mark-as-taken/{id}")
//    public String markAsTaken(@PathVariable Long id) {
//        this.bookService.markAsTaken(id);
//        return "redirect:/books";
//    }
//}
