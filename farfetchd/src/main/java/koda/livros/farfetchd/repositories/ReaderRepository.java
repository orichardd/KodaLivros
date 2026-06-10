package koda.livros.farfetchd.repositories;

import koda.livros.farfetchd.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader getReaderByCode(String code);
}
