package app.service;

import app.Repository.UsersRepository;
import app.model.UsersModel;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public UsersModel registerUser (String login, String password, String email) {
        if (login == null && password == null){
            return null;
        }
        else{
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setEmail(email);
            usersModel.setPassword(password);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate ( String login, String password){
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
