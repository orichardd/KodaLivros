package koda.livros.farfetchd.services;

import koda.livros.farfetchd.DTOs.CreateReaderDTO;
import koda.livros.farfetchd.models.Reader;
import koda.livros.farfetchd.repositories.ReaderRepository;
import koda.livros.farfetchd.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final String codePrefix = "READ";

    private ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public void CreateReader(CreateReaderDTO dto){
        Reader reader = new Reader(
                dto.firstName(),
                dto.lastName(),
                dto.phoneNumber(),
                dto.photoURL()
        );
        readerRepository.save(reader);
        System.out.println(Utils.GenerateCode(codePrefix, reader.getId()));
        reader.setCode(Utils.GenerateCode(codePrefix, reader.getId()));
        readerRepository.save(reader);
    }

    public Reader GetReaderByCode(String code){
        Reader foundReader = readerRepository.getReaderByCode(code);
        if(foundReader == null){
            throw new IllegalArgumentException("Leitor não encontrado.");
        }
        return foundReader;
    }

    public Long CountReader() {
        return readerRepository.count();
    }

    public List<Reader> GetAllReaders() {
        return readerRepository.findAll();
    }
}
