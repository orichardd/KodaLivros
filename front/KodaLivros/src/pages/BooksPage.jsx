import { useEffect, useState } from 'react';
import './booksPage.css';
import api from '../api/api';
import Sidebar from './SideBar';
import BookCard from './components/bookCard.jsx';

export default function BooksPage() {

    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        async function fetchBooks() {

            try {

                const response = await api.get('/books/getAll');

                setBooks(response.data);

            } catch (error) {

                console.error(error);
                alert('Erro ao carregar livros.');

            } finally {

                setLoading(false);

            }
        }

        fetchBooks();

    }, []);

    if (loading) {
        return (
            <div className="container">
                <Sidebar />
                <main className="content">
                    <h2>Carregando...</h2>
                </main>
            </div>
        );
    }

    return (
        <div className="container">

            <Sidebar />

            <main className="content">

                <h1>Livros</h1>

                <div className="books-grid">

                    {books.map((book) => (
                        <BookCard
                            key={book.id}
                            book={book}
                        />
                    ))}

                </div>

            </main>

        </div>
    );
}