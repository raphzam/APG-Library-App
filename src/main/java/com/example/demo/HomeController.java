package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    //    CATEGORY METHODS
    @GetMapping("/newcategory")
    public String loadCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/processcategory")
    public String processCategoryForm(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }

    @RequestMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "categoryform";
    }


    //    BOOK METHODS
    @GetMapping("/newbook")
    public String loadBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "bookform";
    }

    @PostMapping("/processbook")
    public String processBookForm(@ModelAttribute Book book, @RequestParam("file") MultipartFile file, Model model) {

        //Cover art upload is optional
        if (!file.isEmpty()) {
            try {
                Map uploadResult = cloudinaryConfig.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                book.setCoverArt(uploadResult.get("url").toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bookRepository.save(book);
        model.addAttribute("book", book);
        return "bookdetail";
    }

    @RequestMapping("/updatebook/{id}")
    public String updateBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());
        return "bookform";
    }

    @RequestMapping("/bookdetail/{id}")
    public String bookDetail(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "bookdetail";
    }


    public String toggleStatus() {
        return "redirect:/";
    }

}



