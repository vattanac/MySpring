package com.vattanac.demo.models;

import com.github.javafaker.Cat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Book {


    public int id;

    @NotNull
    @Size(min = 5, max = 50, message = "can't be greater then 5")
    public String title;
    public String author;
    public String publisher;
    private String thumbnail;


    private Category category;


    public Book() {

    }

    public Book(int id, @NotNull
    @Size(min = 5, max = 50, message = "can't be greater then 5") String title, String author, String publisher, String thumbnail,Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.thumbnail = thumbnail;
        this.category =category;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", category=" + category +
                '}';
    }
}
