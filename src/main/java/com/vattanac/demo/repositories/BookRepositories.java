package com.vattanac.demo.repositories;

import com.github.javafaker.Faker;
import com.vattanac.demo.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositories {
    Faker faker = new Faker();
    List<Book> bookList = new ArrayList<>();
    {
        for (int i = 1; i < 11; i++) {
            Book book = new Book();
            book.setId(i);
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setPublisher(faker.book().publisher());

            bookList.add(book);
        }
    }
    public List<Book> getAll(){
        return  this.bookList;
    }
    public Book findOne(Integer id){
        for (int i = 0; i <bookList.size() ; i++) {
            if (bookList.get(i).getId()==id){
                return  bookList.get(i);
            }
        }
        return null;
    }


    public boolean Update(Book book){
        for (int i = 0; i <bookList.size() ; i++) {
            if (bookList.get(i).getId() == book.getId()){
                bookList.set(i,book);
                return  true;
            }
        }
        return  false;
    }

    public boolean remove(Integer id){
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id){
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }
//2
    public Integer count(){
        return  this.bookList.size();
    }

    public boolean create(Book book){

        return bookList.add(book);
    }

}
