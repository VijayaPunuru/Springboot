package com.cis.java.spingboot.service;
import com.cis.java.spingboot.model.Book;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class BookService {

    private Map<Integer, Book> bookMap = new HashMap<>();

    public Book createBook(Book book) {
        int bookId = (int) new Random().nextInt();
        book.setBookId(bookId);
        bookMap.put(bookId, book);
        return book;
    }

    public Book getBook(int bookId) {
        return bookMap.get(bookId);

    }
    public void deleteBook(int bookId) {
        bookMap.remove(bookId);
    }
    public boolean updateBook(int bookId, Book book) {
        if (bookMap.containsKey(bookId)) {
            book.setBookId(bookId);
            bookMap.put(bookId, book);
            return true;
        } else {
            return false;
        }
    }
}