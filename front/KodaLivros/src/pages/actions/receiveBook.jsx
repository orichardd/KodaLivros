
import { useState } from 'react';
import api from '../../api/api';

async function ReturnBook(bookCode) {

    if (!bookCode) {
        throw new Error("Informe o código do livro.");
    }

    const response = await api.post('/loan/end', {
        bookCode
    });

    return response.data;
}

export default function ReceiveBook() {

    const [bookCode, setBookCode] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {

            const response = await ReturnBook(bookCode);

            alert(response || "Livro recebido com sucesso!");

            setBookCode('');

        } catch (error) {

            alert(
                error.response?.data ||
                error.message ||
                "Erro ao receber livro."
            );

        }
    };

    return (
        <div className="popup">
            <h2>Receber Livro</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Código do Livro"
                    value={bookCode}
                    onChange={(e) => setBookCode(e.target.value)}
                />

                <button type="submit">
                    Receber
                </button>

            </form>
        </div>
    );
}