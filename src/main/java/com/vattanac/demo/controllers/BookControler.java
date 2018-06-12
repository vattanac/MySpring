package com.vattanac.demo.controllers;

import com.vattanac.demo.models.Book;
import com.vattanac.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookControler {

    private BooksService booksService;

    @Autowired
    public BookControler(BooksService booksService) {
        this.booksService = booksService;
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
        return "book/update";
    }

    @PostMapping("update/submit")
    public String updateSubmit(@ModelAttribute Book book) {
        System.out.println(book);

        this.booksService.Uppate(book);
        return "redirect:/index";

    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable Integer id) {
        this.booksService.remove(id);

        return "redirect:/";
    }

    //2
    @GetMapping("/count")
    @ResponseBody
    public Map<String, Object> count() {
        Map<String, Object> response = new HashMap<>();

        response.put("record_count", this.booksService.count());
        response.put("status", true);

        return response;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/create-book";
    }

    @PostMapping("/create/submit")
    public String createSubmit(@Valid Book book,
        BindingResult bindingResult, MultipartFile file) {


        System.out.println(book);

        if (bindingResult.hasErrors()){
            return "book/create-book";
        }

        if (file == null)return null;

        File path = new File("/pp6th");
        if (!path.exists())
            path.mkdir();


        this.booksService.create(book);
        return "redirect:/home";

    }


}





















