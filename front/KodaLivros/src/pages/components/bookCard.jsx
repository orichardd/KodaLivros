import './bookCard.css';

export default function BookCard({ book }) {

    return (
        <div className="book-card">

            <img
                className="book-cover"
                src={
                    book.pictureURL ||
                    "https://via.placeholder.com/250x350?text=Sem+Capa"
                }
                alt={book.title}
            />

            <div className="book-info">

                <h2>{book.title}</h2>

                <p>
                    <strong>Autor:</strong> {book.author}
                </p>

                <p>
                    <strong>Código:</strong> {book.code}
                </p>

                <p
                    className={
                        book.taken
                            ? "status taken"
                            : "status available"
                    }
                >
                    {book.taken
                        ? "Emprestado"
                        : "Disponível"}
                </p>

                <p className="description">
                    {book.description}
                </p>

            </div>

        </div>
    );
}