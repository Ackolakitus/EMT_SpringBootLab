package mk.ukim.finki.emt.lab.web.rest;

import mk.ukim.finki.emt.lab.model.enumerations.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    public List<Category> listAllCategories(){
        return List.of(Category.values());
    }
}
