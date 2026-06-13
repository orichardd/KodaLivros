import { useEffect, useState } from 'react';
import api from '../api/api';

import Sidebar from './SideBar';
import LoanCard from './components/LoanCard.jsx';

import './LoansPage.css';

export default function LoansPage() {

    const [loans, setLoans] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        async function fetchLoans() {

            try {

                const response = await api.get('/loan/getAll');

                setLoans(response.data);

            } catch (error) {

                console.error(error);
                alert('Erro ao carregar empréstimos.');

            } finally {

                setLoading(false);

            }
        }

        fetchLoans();

    }, []);

    if (loading) {
        return <h2>Carregando...</h2>;
    }

    return (
        <div className="container">

            <Sidebar />

            <main className="content">

                <h1>Empréstimos</h1>

                <div className="loans-grid">

                    {loans.map((loan) => (
                        <LoanCard
                            key={loan.id}
                            loan={loan}
                        />
                    ))}

                </div>

            </main>

        </div>
    );
}