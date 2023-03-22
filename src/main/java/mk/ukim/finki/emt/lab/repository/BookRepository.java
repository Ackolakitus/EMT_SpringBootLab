package mk.ukim.finki.emt.lab.repository;

import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
    void deleteByName(String name);
    List<Book> findAllByAuthor(Author author);
    List<Book> findAllByCategory(Category category);
}
