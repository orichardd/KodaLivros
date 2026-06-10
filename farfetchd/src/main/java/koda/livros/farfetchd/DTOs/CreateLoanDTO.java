package koda.livros.farfetchd.DTOs;

public record CreateLoanDTO(
        String bookCode,
        String readerCode,
        int days
) {
}
