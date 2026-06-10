package koda.livros.farfetchd.DTOs;

public record CreateReaderDTO(
        String firstName,
        String lastName,
        String phoneNumber,
        String photoURL
) {
}
