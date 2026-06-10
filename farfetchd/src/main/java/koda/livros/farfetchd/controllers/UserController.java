package koda.livros.farfetchd.controllers;

import koda.livros.farfetchd.DTOs.CreateUserDTO;
import koda.livros.farfetchd.DTOs.LoginUserDTO;
import koda.livros.farfetchd.models.User;
import koda.livros.farfetchd.services.UserService;
import koda.livros.farfetchd.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.ReadPendingException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateUser(@RequestBody CreateUserDTO dto){
        userService.CreateUser(dto);
        return ResponseEntity.ok("Usuário criado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginUserDTO dto){
        User user = userService.Login(dto);
        return ResponseEntity.ok().body(user);
    }

}
