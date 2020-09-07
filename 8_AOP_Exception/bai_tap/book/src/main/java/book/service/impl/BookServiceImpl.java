package book.service.impl;

import book.model.Book;
import book.repository.BookRepository;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public boolean rentBook(Book book) {
        return bookRepository.rentBook(book);
    }

    @Override
    public void giveBookBack(Book book) {
        bookRepository.giveBookBack(book);
    }
}
