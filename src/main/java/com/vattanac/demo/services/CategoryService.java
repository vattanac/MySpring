package com.vattanac.demo.services;

import com.vattanac.demo.models.Book;
import com.vattanac.demo.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    Integer count();
    List<Category> getAll();
    Category findOne(Integer id);
    boolean Update(Category category);
    boolean remove(Integer id);

    boolean create(Category category);
    List<Category> isExisted(String name);
}
