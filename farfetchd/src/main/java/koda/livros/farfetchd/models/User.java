package koda.livros.farfetchd.models;

import jakarta.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "code", length = 10, unique = true)
    private String code;

    @Column(name = "picture_url", nullable = false, columnDefinition = "TEXT")
    private String pictureURL;

    public User(String username, String password, String pictureURL) {
        this.username = username;
        this.password = password;
        this.pictureURL = pictureURL;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
