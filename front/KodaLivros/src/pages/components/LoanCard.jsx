import './LoanCard.css';

export default function LoanCard({ loan }) {
    const returnDate = new Date(
        loan.maxReturnDate
    ).toLocaleDateString('pt-BR');

    return (
        <div className={`loan-card ${loan.active ? '' : 'loan-card-finished'}`}>

            <img
                className="loan-cover"
                src={
                    loan.book.pictureURL ||
                    "https://via.placeholder.com/250x350?text=Sem+Capa"
                }
                alt={loan.book.title}
            />

            <div className="loan-content">

                <div className="loan-header">

                    <div>
                        <h2>{loan.book.title}</h2>

                        <span className="loan-id">
                            Empréstimo #{loan.id}
                        </span>
                    </div>

                    <span
                        className={`loan-status ${
                            loan.active
                                ? 'loan-status-active'
                                : 'loan-status-inactive'
                        }`}
                    >
                        {loan.active ? 'Emprestado' : 'Devolvido'}
                    </span>

                </div>

                <div className="loan-section">

                    <h3>Livro</h3>

                    <p>
                        <strong>Autor:</strong> {loan.book.author}
                    </p>

                    <p>
                        <strong>Código:</strong> {loan.book.code}
                    </p>

                    <p className="description">
                        {loan.book.description}
                    </p>

                </div>

                <div className="loan-section">

                    <h3>Leitor</h3>

                    <p>
                        <strong>Nome:</strong>{" "}
                        {loan.reader.firstName} {loan.reader.lastName}
                    </p>

                    <p>
                        <strong>Código:</strong> {loan.reader.code}
                    </p>

                    <p>
                        <strong>Telefone:</strong> {loan.reader.phoneNumber}
                    </p>

                </div>

                <div className="loan-footer">

                    <span>
                        Prazo de devolução:
                    </span>

                    <strong>
                        {returnDate}
                    </strong>

                </div>

            </div>

        </div>
    );
}