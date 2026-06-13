import { useEffect, useState } from 'react';
import api from '../api/api';

import Sidebar from './SideBar';
import ReaderCard from './components/ReaderCard.jsx';

import './ReadersPage.css';

export default function ReadersPage() {

    const [readers, setReaders] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        async function fetchReaders() {

            try {

                const response = await api.get('/readers/getAll');

                setReaders(response.data);

            } catch (error) {

                console.error(error);
                alert('Erro ao carregar leitores.');

            } finally {

                setLoading(false);

            }
        }

        fetchReaders();

    }, []);

    if (loading) {
        return <h2>Carregando...</h2>;
    }

    return (
        <div className="container">

            <Sidebar />

            <main className="content">

                <h1>Leitores</h1>

                <div className="readers-grid">

                    {readers.map((reader) => (
                        <ReaderCard
                            key={reader.id}
                            reader={reader}
                        />
                    ))}

                </div>

            </main>

        </div>
    );
}