package koda.livros.farfetchd.services;

import koda.livros.farfetchd.DTOs.CreateUserDTO;
import koda.livros.farfetchd.DTOs.LoginUserDTO;
import koda.livros.farfetchd.models.User;
import koda.livros.farfetchd.repositories.UserRepository;
import koda.livros.farfetchd.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final String codePrefix = "ADMIN";

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void CreateUser(CreateUserDTO dto){
        User foundUser = userRepository.getUserByUsername(dto.username());
        if(foundUser != null){
            throw new IllegalArgumentException("username já cadastrado.");
        }
        User newUser = new User(
                dto.username(),
                dto.password(),
                dto.pictureURL()
        );
        userRepository.save(newUser);
        newUser.setCode(Utils.GenerateCode(codePrefix, newUser.getId()));
        userRepository.save(newUser);
    }



    public User GetUserByCode(String code){
        User foundUser = userRepository.getUserByCode(code);
        if(foundUser == null){
            throw new IllegalArgumentException("Código de gerente inválido");
        }
        return(foundUser);
    }

    public User Login(LoginUserDTO dto) {
        User foundUser = userRepository.getUserByUsername(dto.username());
        if(foundUser == null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        if(!foundUser.getPassword().equals(dto.password())){
            throw new IllegalArgumentException("Senha incorreta");
        }
        return foundUser;
    }
}
