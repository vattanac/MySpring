package com.vattanac.demo.services.impl;

import com.vattanac.demo.models.Category;
import com.vattanac.demo.repositories.CategoryRepository;
import com.vattanac.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService
{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }

    @Override
    public Integer count() {
        return this.categoryRepository.count();
    }

    @Override
    public Category findOne(Integer id) {
        return  categoryRepository.findOne(id);
    }

    @Override
    public boolean Update(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public boolean remove(Integer id) {
        return categoryRepository.delete(id);
    }

    @Override
    public boolean create(Category category) {
        return categoryRepository.add(category);
    }

    @Override
    public List<Category> isExisted(String name) {
        return categoryRepository.isExisted(name);
    }


}
