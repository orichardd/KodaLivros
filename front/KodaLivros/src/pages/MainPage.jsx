import './MainPage.css';
import '../index.css'
import { useState, useEffect } from 'react';

import SideBar from "./SideBar.jsx";
import AddBook from './actions/addbook';
import AddReader from './actions/addReader';
import CreateLoan from './actions/createLoan';
import ReceiveBook from './actions/receiveBook';
import api from '../api/api';
import { useNavigate } from 'react-router-dom';

export default function MainPage() {

    const [popup, setPopup] = useState(null);
    const [books, setBooks] = useState([]);
    const [loans, setLoans] = useState([]); 
    const [readers, setReaders] = useState([]);
    const navigate = useNavigate();

    async function fetchBooks() {
        try{
            const response = await api.get('/books/count');
            setBooks(response.data);
        } catch (error) {
            console.error('Error fetching books:', error);
        }
    };
    async function fetchLoans() {
        try{
            const response = await api.get('/loan/count');
            setLoans(response.data);
        } catch (error) {
            console.error('Error fetching loans:', error);
        }
    };
    async function fetchReaders() {
        try{
            const response = await api.get('/readers/count');
            setReaders(response.data);
        } catch (error) {
            console.error('Error fetching readers:', error);
        }
    };
    useEffect(() => {
        fetchBooks();
        fetchLoans();
        fetchReaders();

        if(localStorage.getItem("adminCode") == null){
        alert("Faça login para acessar o sistema.");
        navigate('/login');
    };
    }, []);

    return (
        <div className="container">

            <SideBar />

            <main className="content">

                <h2>Olá João</h2>

                <div className="stats">

                    <div className="card">
                        <img src="../icons/book.png" alt="Livros Disponíveis" className="top-icon" />
                        <h3>{books}</h3>
                        <p>Livros Disponíveis</p>
                    </div>

                    <div className="card">
                        <img src="../icons/exchange.png" alt="Empréstimos" className="top-icon" />
                        <h3>{loans}</h3>
                        <p>Empréstimos ativos</p>
                    </div>

                    <div className="card">
                        <img src="../icons/person.png" alt="Leitores Registrados" className="top-icon" />
                        <h3>{readers}</h3>
                        <p>Leitores registrados</p>
                    </div>

                </div>

                <div className="actions">

                    <button
                        className="green"
                        onClick={() => setPopup('addBook')}
                    >
                        <img src="../icons/book.png" alt="Adicionar Livro" className="button-icon" />
                        <span>+</span>
                        Adicionar Livro
                    </button>

                    <button
                        className="blue"
                        onClick={() => setPopup('addUser')}
                    >
                        <img src="../icons/person.png" alt="Criar Usuários" className="button-icon" />
                        <span>+</span>
                        Criar Usuários
                    </button>

                    <button
                        className="yellow"
                        onClick={() => setPopup('loan')}
                    >
                        <img src="../icons/exchange.png" alt="Criar Empréstimo" className="button-icon" />
                        <span>+</span>
                        Criar empréstimo
                    </button>

                    <button
                        className="red"
                        onClick={() => setPopup('return')}
                    >
                        <img src="../icons/book.png" alt="Receber Livro" className="button-icon" />
                        <span>+</span>
                        Receber Livro
                    </button>

                </div>

            </main>

            {popup && (
                <div className="modal-overlay">

                    <div className="modal">

                        <button
                            className="close-button"
                            onClick={() => setPopup(null)}
                        >
                            ✕
                        </button>

                        {popup === 'addBook' && <AddBook />}
                        {popup === 'addUser' && <AddReader />}
                        {popup === 'loan' && <CreateLoan />}
                        {popup === 'return' && <ReceiveBook />}

                    </div>

                </div>
            )}

        </div>
    );
}