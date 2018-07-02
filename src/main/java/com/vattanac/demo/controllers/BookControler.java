package com.vattanac.demo.controllers;

import com.github.javafaker.Cat;
import com.vattanac.demo.models.Book;
import com.vattanac.demo.models.Category;
import com.vattanac.demo.services.BooksService;
import com.vattanac.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
public class BookControler {

    private BooksService booksService;
    private  CategoryService categoryService;

    @Autowired
    public BookControler(BooksService booksService, CategoryService categoryService) {
        this.booksService = booksService;
        this.categoryService = categoryService;
    }

    // @GetMapping("/index")
    @RequestMapping(method = RequestMethod.GET, value = {"/index", "/", "home"})
    public String index(ModelMap model) {
        List<Book> bookList = this.booksService.getAll();
        model.addAttribute("books", bookList);
        return "book/index";
    }


    @GetMapping("/view/{id}")
    public String viewDetail(@PathVariable("id") Integer id, ModelMap model) {
        Book book = this.booksService.findOne(id);
        model.addAttribute("book", book);
        return "book/view-detail";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, ModelMap model) {
        Book book = this.booksService.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("categories",categoryService.getAll());
        return "book/update-book";
    }

    @PostMapping("/update/submit")
    public String updateSubmit(@ModelAttribute Book book, @ModelAttribute Category category, MultipartFile file) {
        System.out.println(book);

        if (file.isEmpty()) {
            String tmp = booksService.findOne(book.id).getThumbnail();
            book.setThumbnail(tmp);
        }

        String filename = file.getOriginalFilename();

        String extension = filename.substring(filename.lastIndexOf('.') + 1);


        System.out.println(extension);

        filename = UUID.randomUUID() + "." + extension;
        System.out.println(filename);
        try {

            Files.copy(file.getInputStream(), Paths.get("/Users/mac/Documents/Admin/HRD/Project/Spring/Topic3/pp6th", filename));
        } catch (IOException e) {

        }

        if (!file.isEmpty()) book.setThumbnail("/images-pp/" + filename);
        this.booksService.Update(book);
        return "redirect:/index";

    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable Integer id) {
        this.booksService.remove(id);
        return "redirect:/";
    }

    //2
//    @GetMapping("/count")
//    @ResponseBody
//    public Map<String, Object> count() {
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("record_count", this.booksService.count());
//        response.put("status", true);
//
//        return response;
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories",categoryService.getAll());
        return "book/create-book";
    }

    @PostMapping("/create/submit")
    public String createSubmit(@Valid Book book, BindingResult bindingResult, MultipartFile file) {
        //System.out.println(book);
        if (bindingResult.hasErrors()) {
            System.out.println("HElL YA");
            return "book/create-book";
        }

        File path = new File("/Users/mac/Documents/Admin/HRD/Project/Spring/Topic3/pp6th");
        if (!path.exists())
            path.mkdirs();

        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf('.') + 1);

        System.out.println(filename);
        System.out.println(extension);

        filename = UUID.randomUUID() + "." + extension;
        System.out.println(filename);
        try {
            Files.copy(file.getInputStream(), Paths.get("/Users/mac/Documents/Admin/HRD/Project/Spring/Topic3/pp6th", filename));
        } catch (IOException e) {

        }
        book.setThumbnail("/images-pp/" + filename);
        System.out.println("fdfdsf" + book.getThumbnail());
        if (!file.isEmpty()) {
            this.booksService.create(book);
        }
        System.out.println(book);
        return "redirect:/index";

    }

    @RequestMapping("/req")
    public String Req() {
        return "book/category";
    }


}





















