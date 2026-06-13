import { Link } from 'react-router-dom';

export default function SideBar() {
    return (
        <aside className="sidebar">
            <h1>KodaLivros</h1>

            <nav>
                <Link to="/" className="nav-link">
                    <img src="../icons/home.png" alt="Início" className="left-icon" />
                    Início
                </Link>

                <Link to="/books" className="nav-link">
                    <img src="../icons/book.png" alt="Livros" className="left-icon" />
                    Livros
                </Link>

                <Link to="/loans" className="nav-link">
                    <img src="../icons/exchange.png" alt="Empréstimos" className="left-icon" />
                    Empréstimos
                </Link>

                <Link to="/readers" className="nav-link">
                    <img src="../icons/person.png" alt="Adicionar Leitor" className="left-icon" />
                    Leitores
                </Link>
                <Link to="/settings" className="nav-link">
                    <img src="../icons/gear.png" alt="Configurações" className="left-icon" />
                    Configurações
                </Link>
            </nav>

            <Link to="/logout" className="nav-link logout">
                <img src="../icons/logout.png" alt="Logout" className="left-icon" />
                Logout
            </Link>
        </aside>
    );
}