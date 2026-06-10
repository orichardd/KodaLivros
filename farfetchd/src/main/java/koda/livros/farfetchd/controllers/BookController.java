package koda.livros.farfetchd.controllers;

import koda.livros.farfetchd.DTOs.CreateBookDTO;
import koda.livros.farfetchd.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateBook(@RequestBody CreateBookDTO dto){
        bookService.CreateBook(dto);
        return ResponseEntity.ok("Livro adicionado com sucesso.");
    }

    @GetMapping("/count")
    public ResponseEntity<?> CountBooks(){
        return ResponseEntity.ok(bookService.CountBooks());
    }

}
