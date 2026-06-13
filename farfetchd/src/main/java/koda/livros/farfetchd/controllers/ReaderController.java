package koda.livros.farfetchd.controllers;

import koda.livros.farfetchd.DTOs.CreateReaderDTO;
import koda.livros.farfetchd.services.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateReader(@RequestBody CreateReaderDTO dto){
        readerService.CreateReader(dto);
        return ResponseEntity.ok("Leitor criado com sucesso.");
    }

    @GetMapping("/count")
    public ResponseEntity<?> CountReaders(){
        return ResponseEntity.ok(readerService.CountReader());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> GetAllReaders(){
        return ResponseEntity.ok(readerService.GetAllReaders());
    }

}