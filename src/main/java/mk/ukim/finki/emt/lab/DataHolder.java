package mk.ukim.finki.emt.lab;

import lombok.Getter;
import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {


    public static List<Book> books = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

//    @PostConstruct
//    public void init(){
//
//
//    }
}
