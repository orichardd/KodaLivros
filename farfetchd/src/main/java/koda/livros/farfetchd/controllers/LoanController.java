package koda.livros.farfetchd.controllers;

import koda.livros.farfetchd.DTOs.CreateLoanDTO;
import koda.livros.farfetchd.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    public ResponseEntity<?> CreateLoan(CreateLoanDTO dto){
        loanService.CreateLoan(dto);
        return ResponseEntity.ok("Criado com sucesso");
    }

    @PostMapping("/end")
    public ResponseEntity<?> EndLoan(@RequestParam String bookCode){
        return ResponseEntity.ok(loanService.EndLoan(bookCode));
    }

}
