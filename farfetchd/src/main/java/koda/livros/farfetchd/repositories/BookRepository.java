package koda.livros.farfetchd.repositories;

import koda.livros.farfetchd.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookByCode(String code);
}
