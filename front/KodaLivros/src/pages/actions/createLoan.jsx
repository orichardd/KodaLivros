import { useState } from 'react';
import api from '../../api/api';

async function PostLoan(bookCode, readerCode, loanDays) {

    if (!bookCode || !readerCode || !loanDays) {
        throw new Error("Preencha todos os campos.");
    }

    const adminCode = localStorage.getItem("adminCode");

    const response = await api.post('/loan/create', {
        bookCode,
        readerCode,
        days: Number(loanDays),
        adminCode
    });

    return response.data;
}

export default function CreateLoan() {

    const [bookCode, setBookCode] = useState('');
    const [readerCode, setReaderCode] = useState('');
    const [loanDays, setLoanDays] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {

            const response = await PostLoan(
                bookCode,
                readerCode,
                loanDays
            );

            alert(response || "Empréstimo criado com sucesso!");

            setBookCode('');
            setReaderCode('');
            setLoanDays('');

        } catch (error) {

            alert(
                error.response?.data ||
                error.message ||
                "Erro ao criar empréstimo."
            );

        }
    };

    return (
        <div className="popup">
            <h2>Criar Empréstimo</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Código do Livro"
                    value={bookCode}
                    onChange={(e) => setBookCode(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Código do Leitor"
                    value={readerCode}
                    onChange={(e) => setReaderCode(e.target.value)}
                />

                <input
                    type="number"
                    placeholder="Dias de Empréstimo"
                    value={loanDays}
                    onChange={(e) => setLoanDays(e.target.value)}
                />

                <button type="submit">
                    Adicionar
                </button>

            </form>
        </div>
    );
}