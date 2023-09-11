//package mk.ukim.finki.emt.lab.web.controller;
//
//import mk.ukim.finki.emt.lab.model.enumerations.Category;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(value = "/categories")
//public class CategoryController {
//
//    public CategoryController() {
//    }
//
//    @GetMapping
//    public String getCategoryPage(Model model){
//        model.addAttribute("categories", Category.values());
//        return "categories";
//    }
//}
