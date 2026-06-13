package koda.livros.farfetchd.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "code", length = 10, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    private User createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "picture_url", columnDefinition = "TEXT")
    private String pictureURL;

    @Column(name = "is_taken")
    private boolean isTaken;

    public Book(String title, String description, String author, User createdBy, String pictureURL) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.createdBy = createdBy;
        this.createdAt = LocalDate.now();
        this.pictureURL = pictureURL;
        this.isTaken = false;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void SetIsTaken(boolean bool){
        this.isTaken = bool;
    }

    public boolean isTaken() {
        return isTaken;
    }
}
