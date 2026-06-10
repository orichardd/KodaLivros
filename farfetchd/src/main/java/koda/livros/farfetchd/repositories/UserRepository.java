package koda.livros.farfetchd.repositories;

import koda.livros.farfetchd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByCode(String code);

    User getUserByUsername(String username);
}
