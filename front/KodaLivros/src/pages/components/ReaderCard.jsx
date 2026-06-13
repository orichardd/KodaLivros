import './ReaderCard.css';

export default function ReaderCard({ reader }) {

    return (
        <div className="reader-card">

            <img
                className="reader-picture"
                src={
                    reader.pictureURL ||
                    "https://via.placeholder.com/200?text=Leitor"
                }
                alt={`${reader.firstName} ${reader.lastName}`}
            />

            <div className="reader-info">

                <h2>
                    {reader.firstName} {reader.lastName}
                </h2>

                <p>
                    <strong>Código:</strong> {reader.code}
                </p>

                <p>
                    <strong>Telefone:</strong> {reader.phoneNumber}
                </p>

                <p>
                    <strong>Máx. Livros:</strong> {reader.maxBooks}
                </p>

            </div>

        </div>
    );
}