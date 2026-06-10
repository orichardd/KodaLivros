package koda.livros.farfetchd.models;

import jakarta.persistence.*;

@Entity(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "picture_url", columnDefinition = "TEXT")
    private String pictureURL;

    @Column(name = "code", unique = true, length = 10)
    private String code;

    @Column(name = "max_books")
    private Integer maxBooks;

    public Reader(String firstName, String lastName, String phoneNumber, String pictureURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pictureURL = pictureURL;
        this.maxBooks = 5;
    }

    public Reader() {

    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(Integer maxBooks) {
        this.maxBooks = maxBooks;
    }

    public String getCode() {
        return code;
    }

    public Long getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
