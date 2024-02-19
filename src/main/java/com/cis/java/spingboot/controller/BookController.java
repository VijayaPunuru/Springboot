package com.cis.java.spingboot.controller;
import com.cis.java.spingboot.model.Book;
import com.cis.java.spingboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable int bookId){

        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable int bookId){

        bookService.deleteBook(bookId);
    }
    @PostMapping
        public Book createBook(@RequestBody  Book book){

        return bookService.createBook(book);
    }

    @PutMapping("/{bookId}")
    public boolean updateBook(@PathVariable int bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }
}