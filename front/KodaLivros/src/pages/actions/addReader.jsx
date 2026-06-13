import { useState } from 'react';
import api from '../../api/api';

async function PostReader(firstName, lastName, phoneNumber) {

    if (!firstName || !lastName || !phoneNumber) {
        throw new Error("Preencha todos os campos.");
    }

    const response = await api.post('/readers/create', {
        firstName,
        lastName,
        phoneNumber,
        photoURL: `https://tse1.mm.bing.net/th?q=${firstName}+${lastName}`
    });

    return response.data;
}

export default function AddReader() {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {

            const response = await PostReader(
                firstName,
                lastName,
                phoneNumber
            );

            alert(response || "Leitor adicionado com sucesso!");

            setFirstName('');
            setLastName('');
            setPhoneNumber('');

        } catch (error) {

            alert(
                error.response?.data ||
                error.message ||
                "Erro ao adicionar leitor."
            );

        }
    };

    return (
        <div className="popup">
            <h2>Adicionar Leitor</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Primeiro nome"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Sobrenome"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Número de telefone"
                    value={phoneNumber}
                    onChange={(e) => setPhoneNumber(e.target.value)}
                />

                <button type="submit">
                    Adicionar
                </button>

            </form>
        </div>
    );
}