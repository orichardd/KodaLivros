package koda.livros.farfetchd.repositories;

import koda.livros.farfetchd.models.Book;
import koda.livros.farfetchd.models.Loan;
import koda.livros.farfetchd.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan getLoanByBook(Book book);

    Loan getLoanByActiveAndBook(boolean active, Book book);

    Long findLoansByActive(boolean active);

    Long countLoansByActive(boolean active);

    List<Loan> getLoansByActiveAndReader(boolean active, Reader reader);
}
