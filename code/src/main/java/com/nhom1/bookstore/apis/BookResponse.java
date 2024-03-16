package com.nhom1.bookstore.apis;

import com.nhom1.bookstore.entity.Book;

public class BookResponse {
    private Book book;
    private String message;

    public BookResponse(Book book, String message) {
        this.book = book;
        this.message = message;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
