package com.vattanac.demo.repositories;

import com.github.javafaker.Faker;
import com.vattanac.demo.models.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepositories {


@Select("select* from tbl_book")
List<Book> getAll();

@Select("select* from tbl_book where id=#{id}")
Book findOne(@Param("id") Integer id);

@Update("update tbl_book set title =#{title}, author=#{author}, publisher=#{publisher}, thumbnail=#{thumbnail} where id=#{id}")
boolean Update(Book book);

@Delete("delete from tbl_book where id=#{id}")
boolean remove(Integer id);

@Insert("insert into tbl_book(title,author, publisher,thumbnail) values(#{title} ,#{author},#{publisher},#{thumbnail})")
 boolean creat(Book book);

//    Faker faker = new Faker();
//    List<Book> bookList = new ArrayList<>();
//    {
//        for (int i = 1; i < 11; i++) {
//            Book book = new Book();
//            book.setId(i);
//            book.setTitle(faker.book().title());
//            book.setAuthor(faker.book().author());
//            book.setPublisher(faker.book().publisher());
//
//            bookList.add(book);
//        }
//    }
//    public List<Book> getAll(){
//        return  this.bookList;
//    }
//    public Book findOne(Integer id){
//        for (int i = 0; i <bookList.size() ; i++) {
//            if (bookList.get(i).getId()==id){
//                return  bookList.get(i);
//            }
//        }
//        return null;
//    }
//
//
//    public boolean Update(Book book){
//        for (int i = 0; i <bookList.size() ; i++) {
//            if (bookList.get(i).getId() == book.getId()){
//                bookList.set(i,book);
//                return  true;
//            }
//        }
//        return  false;
//    }
//
//    public boolean remove(Integer id){
//        for (int i = 0; i < bookList.size(); i++) {
//            if (bookList.get(i).getId() == id){
//                bookList.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
////2
//    public Integer count(){
//        return  this.bookList.size();
//    }
//
//    public boolean create(Book book){
//
//        return bookList.add(book);
//    }

}
