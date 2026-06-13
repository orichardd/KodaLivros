import './addbook.css';
import { useState } from 'react';
import api from '../../api/api';

async function PostBook(title, description, author) {

    if (!title || !description || !author) {
        throw new Error("Preencha todos os campos.");
    }

    const pictureURL = `https://tse1.mm.bing.net/th?q=${title}`;

    const adminCode = "ADMIN00001";

    const response = await api.post('/books/create', {
        title,
        description,
        author,
        pictureURL,
        adminCode
    });

    return response.data;
}

export default function AddBook() {

    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [author, setAuthor] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {

            const response = await PostBook(
                title,
                description,
                author
            );

            alert(response || "Livro adicionado com sucesso!");

            setTitle('');
            setDescription('');
            setAuthor('');

        } catch (error) {

            alert(
                error.response?.data ||
                error.message ||
                "Erro ao adicionar livro."
            );

        }
    };

    return (
        <div className="popup">
            <h2>Adicionar Livro</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Título do Livro"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Descrição"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Autor"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                />

                <button type="submit">
                    Adicionar
                </button>

            </form>
        </div>
    );
}