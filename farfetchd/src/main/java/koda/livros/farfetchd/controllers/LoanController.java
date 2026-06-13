package koda.livros.farfetchd.controllers;

import koda.livros.farfetchd.DTOs.CreateLoanDTO;
import koda.livros.farfetchd.DTOs.EndLoanDTO;
import koda.livros.farfetchd.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/count")
    public ResponseEntity<?> GetLoanCount(){
        return ResponseEntity.ok(loanService.CountLoans());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> GetAll(){
        return ResponseEntity.ok(loanService.GetAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateLoan(@RequestBody CreateLoanDTO dto){
        loanService.CreateLoan(dto);
        return ResponseEntity.ok("Criado com sucesso");
    }

    @PostMapping("/end")
    public ResponseEntity<?> EndLoan(@RequestBody EndLoanDTO dto){
        return ResponseEntity.ok(loanService.EndLoan(dto.bookCode()));
    }

}