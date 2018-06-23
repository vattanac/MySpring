package com.vattanac.demo.services.impl;

import com.vattanac.demo.models.Book;
import com.vattanac.demo.repositories.BookRepositories;
import com.vattanac.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplemetation implements BooksService {


    private BookRepositories bookRepositories;

    @Autowired
    public BookServiceImplemetation(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepositories.getAll();
    }

    @Override
    public Book findOne(Integer id) {
        return this.bookRepositories.findOne(id);
    }

    @Override
    public boolean Update(Book book) {
        return this.bookRepositories.Update(book);
    }

    @Override
    public boolean remove(Integer id) {
        return this.bookRepositories.remove(id);
    }

    @Override
    public boolean create(Book book) {
        return this.bookRepositories.creat(book);
    }


//    @Override
//    public Integer count() {
//        return this.bookRepositories.count();
//    }
//

}
