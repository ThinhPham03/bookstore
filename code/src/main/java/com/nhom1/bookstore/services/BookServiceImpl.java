package com.nhom1.bookstore.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

import com.nhom1.bookstore.entity.Book;
import com.nhom1.bookstore.repositories.BookDAOController;

@Service
public class BookServiceImpl implements BookService{
        private final BookDAOController bookDAOController;

    public BookServiceImpl(BookDAOController bookDAOController) {
        this.bookDAOController = bookDAOController;
    }

    @Override
    public List<Book> getBookList() {
        return bookDAOController.getBookList();
    }

    @Override
    public Book getBook(String id) {
        return bookDAOController.getBook(id);
    }

    @Override
    public void editBook(String currentID, Book newBook) {
        bookDAOController.editBook(currentID, newBook);
    }

    @Override
    public List<Book> search(String tuKhoa) {
        return bookDAOController.search(tuKhoa);
    }

    @Override
    public void deleteBook(String id) {
        bookDAOController.deleteBook(id);;
    }

    @Override
    public void addBook(Book newBook) {

    }

    @Override
    public List<Book> getTopSelling() {
        List<Book> booklist = bookDAOController.getBookList();
        Collections.sort(booklist, Comparator.comparingInt(Book::getDaBan).reversed());

        return booklist.subList(0, Math.min(5, booklist.size()));
    }
}
