package koda.livros.farfetchd.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    @Column(nullable = false, name = "max_return_date")
    private LocalDate maxReturnDate;

    //pq eu nao consigo ara de ouvir weezer?

    @Column(name = "active")
    private boolean active;

    public Loan(Book book, Reader reader, LocalDate maxReturnDate) {
        this.book = book;
        this.reader = reader;
        this.maxReturnDate = maxReturnDate;
        this.active = true;
    }

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getMaxReturnDate() {
        return maxReturnDate;
    }

    public void setInactive(){
        this.active = false;
    }
}
