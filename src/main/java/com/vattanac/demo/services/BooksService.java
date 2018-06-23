package com.vattanac.demo.services;

import com.vattanac.demo.models.Book;

import java.util.List;

public interface BooksService {
    List<Book> getAll();
    Book findOne(Integer id);
    boolean Update(Book book);
    boolean remove(Integer id);

    //2
    //Integer count();
    boolean create(Book book);
}
