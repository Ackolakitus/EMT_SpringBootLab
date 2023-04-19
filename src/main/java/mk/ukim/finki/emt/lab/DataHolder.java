package mk.ukim.finki.emt.lab;

import lombok.Getter;
import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.Country;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import mk.ukim.finki.emt.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.repository.BookRepository;
import mk.ukim.finki.emt.lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Getter
public class DataHolder {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @PostConstruct
    public void init() {
        if (countryRepository.count() != 0 || authorRepository.count() != 0 || bookRepository.count() != 0) {
            return;
        }
        String[] surnames= {"One", "Two", "Three", "Four", "Five"};
        String[] continents= {"Europe","Asia","Africa","America","Australia"};
        for (int i = 0; i < 5; i++) {
            Country c = new Country();
            c.setName(String.format("Country %d", i));
            c.setContinent(String.format("%s", continents[i]));
            countryRepository.save(c);

            Author a = new Author();
            a.setName("Author");
            a.setSurname(String.format("%s", surnames[i]));
            a.setCountry(c);
            authorRepository.save(a);

            Book b = new Book();
            b.setName(String.format("Book %d", i));
            b.setCategory(Category.values()[i % Category.values().length]);
            b.setAuthor(a);
            b.setAvailableCopies((i+1)*2);
            bookRepository.save(b);
        }
    }

}
