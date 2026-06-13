import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MainPage from './pages/MainPage';
import BooksPage from './pages/BooksPage';
import LoansPage from './pages/LoansPage';
import ReadersPage from './pages/ReadersPage';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage />} />
                <Route path="/books" element={<BooksPage />} />
                <Route path="/loans" element={<LoansPage />} />
                <Route path="/readers" element={<ReadersPage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;