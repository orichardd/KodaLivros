import './LoginPage.css'
import { useState } from 'react';
import api from '../api/api';
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    async function Login(){
        if(username == null || username == "" || password == null || password == ""){
            alert("Preencha os campos de usuário e senha.");
        }
        try{
            const adminCode = await api.post('/users/login', {username, password});
            localStorage.setItem("adminCode", adminCode.data);
            alert("Login bem-sucedido!" + "\nCódigo de Admin: " + adminCode.data);
            navigate('/');
        }
        catch{
            alert("Erro ao fazer login. Verifique suas credenciais.");
        }
    }

    return (
        <div className="LoginPageContainer">
            <div className="LoginPageMain">
                <div className="LoginTitleContainer">
                    <h1>KodaLivros</h1>
                </div>
                <div className="LoginFormContainer">
                    <input 
                        type="text" 
                        placeholder="usuário" 
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <input 
                        type="password" 
                        placeholder="senha" 
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <div className="LoginButtonContainer">
                    <button onClick={Login} type="submit">Login</button>
                </div>
            </div>
        </div>
    )
}