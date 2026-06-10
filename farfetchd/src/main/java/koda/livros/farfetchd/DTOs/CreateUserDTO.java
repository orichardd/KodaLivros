package koda.livros.farfetchd.DTOs;

public record CreateUserDTO(
        String username,
        String password,
        String pictureURL
) {
}
