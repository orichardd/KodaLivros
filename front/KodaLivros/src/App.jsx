import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MainPage from './pages/MainPage';
import BooksPage from './pages/BooksPage';
import LoansPage from './pages/LoansPage';
import ReadersPage from './pages/ReadersPage';
import LoginPage from './pages/LoginPage';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage />} />
                <Route path="/books" element={<BooksPage />} />
                <Route path="/loans" element={<LoansPage />} />
                <Route path="/readers" element={<ReadersPage />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="*" element={<h1>Página Não Encontrada</h1>} />
                <Route path="/settings" element={<h1>Nao implementado ainda</h1>} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;