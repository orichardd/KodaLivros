package koda.livros.farfetchd.DTOs;

public record CreateBookDTO(
        String title,
        String description,
        String author,
        String pictureURL,
        String adminCode
) {
}
