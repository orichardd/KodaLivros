package koda.livros.farfetchd.repositories;

import koda.livros.farfetchd.models.Book;
import koda.livros.farfetchd.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan getLoanByBook(Book book);

    Loan getLoanByActiveAndBook(boolean active, Book book);
}
