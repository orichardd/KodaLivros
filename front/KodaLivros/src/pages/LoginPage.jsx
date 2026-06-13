import './LoginPage.css'

export default function LoginPage() {
    return (
        <>
            <div className="LoginPageMain">
                <div className="LoginTitleContainer">
                    <h1>KodaLivros</h1>
                </div>
                <div className="LoginFormContainer">
                    <input type="text" placeholder="usuário" />
                    <input type="password" placeholder="senha" />
                </div>
                <div className="LoginButtonContainer">
                    <button type="submit">Login</button>
                </div>
            </div>
        </>
    )
}