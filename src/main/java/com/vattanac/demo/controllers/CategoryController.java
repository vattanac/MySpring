package com.vattanac.demo.controllers;

import com.vattanac.demo.models.Category;
import com.vattanac.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/category"})
    public String index(ModelMap model) {
//        List<Category> cateList = this.categoryService.getAll();
        model.addAttribute("categories", categoryService.getAll());
        System.out.println(categoryService.getAll());
        return "category/home";
    }

    @GetMapping("/catecreate")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/catecreate/submit")
    public String createSubmit(@ModelAttribute Category category,BindingResult bindingResult) {

        System.out.println(category);
        this.categoryService.create(category);
        return "redirect:/category";

    }

    @GetMapping("/cateview/{id}")
    public String viewDetail(@PathVariable("id") Integer id, ModelMap model) {
        Category category = this.categoryService.findOne(id);
        model.addAttribute("category", category);
        return "category/view-detail";
    }

    @GetMapping("/cateupdate/{id}")
    public String showUpdateForm(@PathVariable Integer id, ModelMap model) {
        Category category = this.categoryService.findOne(id);
        model.addAttribute("category", category);
        return "update-cate";
    }


    @PostMapping("cateupdate/submit")
    public String updateSubmit(@ModelAttribute Category category, MultipartFile file) {


        String filename = file.getOriginalFilename();

        String extension = filename.substring(filename.lastIndexOf('.') + 1);


        System.out.println(extension);

        filename = UUID.randomUUID() + "." + extension;
        System.out.println(filename);

        return "redirect:/index";

    }

    @GetMapping("cateremove/{id}")
    public String remove(@PathVariable Integer id) {
        this.categoryService.remove(id);
        return "redirect:/";
    }





}






















