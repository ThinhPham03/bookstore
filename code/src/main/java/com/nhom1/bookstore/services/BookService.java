package com.nhom1.bookstore.services;

import java.util.List;

import com.nhom1.bookstore.entity.Book;

public interface BookService {
    List<Book> getBookList();
    Book getBook(String id);
    void addBook(Book newBook);
    void editBook(String currentID, Book newBook);
    void deleteBook(String id);
    List<Book> search(String tuKhoa);
    List<Book> getTopSelling();
}