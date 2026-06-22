package koda.livros.farfetchd.services;

import koda.livros.farfetchd.DTOs.CreateLoanDTO;
import koda.livros.farfetchd.models.Book;
import koda.livros.farfetchd.models.Loan;
import koda.livros.farfetchd.models.Reader;
import koda.livros.farfetchd.repositories.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    private ReaderService readerService;
    private BookService bookService;
    private LoanRepository loanRepository;

    public LoanService(ReaderService readerService, BookService bookService, LoanRepository loanRepository) {
        this.readerService = readerService;
        this.bookService = bookService;
        this.loanRepository = loanRepository;
    }

    public void CreateLoan(CreateLoanDTO dto){
        Reader reader = readerService.GetReaderByCode(dto.readerCode());
        Book book = bookService.GetBookByCode(dto.bookCode());
        if(reader == null || book == null){
            throw new IllegalArgumentException("Usuário ou livro nao encontrado.");
        }
        if(book.isTaken()){
            throw new IllegalArgumentException("Livro já pego");
        }
        List<Loan> numBooks = loanRepository.getLoansByActiveAndReader(true, reader);
        if((long) numBooks.size() >= reader.getMaxBooks()){
            throw new IllegalArgumentException("Limite de empréstimos atingidos");
        }
        LocalDate expectedReturnDate = LocalDate.now().plusDays((dto.days()));
        Loan newLoan = new Loan(
            book,
            reader,
            expectedReturnDate
        );
        loanRepository.save(newLoan);
        book.SetIsTaken(true);
        bookService.UpdateBook(book);
    }

    //se alguém ler isso, por favor entre em contato com richdd.dev@gmail.com
    //Neste mundo uma coisa é certa: as pessoas não tem controle nem mesmo sobre sua própria vontade.

    public Long CountLoans(){

        return loanRepository.countLoansByActive(true);
    }

    public String EndLoan(String bookCode) {
        Book book = bookService.GetBookByCode(bookCode);
        if(book == null){
            throw new ResourceAccessException("Livro não encontrado.");
        }
        Loan loan = loanRepository.getLoanByActiveAndBook(true, book);
        if(loan == null){
            throw new IllegalArgumentException("Livro não está em nenhum empréstimo.");
        }
        LocalDate today = LocalDate.now();
        loan.setInactive();
        loanRepository.save(loan);
        book.SetIsTaken(false);
        bookService.UpdateBook(book);
        if(today.isAfter(loan.getMaxReturnDate()) ){
            return "Livro com atraso. Deveria ser entregue %s e foi em %s, %d dias de atraso.".formatted(loan.getMaxReturnDate(), today, ChronoUnit.DAYS.between(loan.getMaxReturnDate(), today));
        }
        return "Livro entregue com sucesso. Sem atrasos.";

    }

    public List<Loan> GetAll() {
        return loanRepository.findAll();
    }
}
