package koda.livros.farfetchd.services;

import koda.livros.farfetchd.DTOs.CreateBookDTO;
import koda.livros.farfetchd.models.Book;
import koda.livros.farfetchd.models.Reader;
import koda.livros.farfetchd.models.User;
import koda.livros.farfetchd.repositories.BookRepository;
import koda.livros.farfetchd.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final String codePrefix = "BOOK";

    private UserService userService;
    private BookRepository bookRepository;

    public BookService(UserService userService, BookRepository bookRepository) {
        this.userService = userService;
        this.bookRepository = bookRepository;
    }

    public void CreateBook(CreateBookDTO dto){
        User foundUser = userService.GetUserByCode(dto.adminCode());
        if(foundUser == null){
            throw new IllegalArgumentException("Nenhum usuário encontrado.");
        }
        Book newBook = new Book(
                dto.title(),
                dto.description(),
                dto.author(),
                foundUser,
                dto.pictureURL()
        );
        bookRepository.save(newBook);
        newBook.setCode(Utils.GenerateCode(codePrefix, newBook.getId()));
        bookRepository.save(newBook);
    }

    public Integer CountBooks() {
        Long booksSum = bookRepository.count();
        return booksSum.intValue();
    }

    public Book GetBookByCode(String code) {
        Book book = bookRepository.getBookByCode(code);
        if(book == null){
            throw new IllegalArgumentException("Leitor não encontrado.");
        }
        return book;
    }

    public void UpdateBook(Book book) {
        bookRepository.save(book);
        System.out.println("livro atualizado " + book.getTitle());
    }

    public List<Book> GetAll() {
        return bookRepository.findAll();
    }
}
