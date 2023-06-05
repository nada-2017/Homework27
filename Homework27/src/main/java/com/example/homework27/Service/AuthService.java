package com.example.homework27.Service;

import com.example.homework27.Model.MyUser;
import com.example.homework27.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public List<MyUser> getAll(){
        return authRepository.findAll();
    }

    public  void register(MyUser myUser){
        String hash = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hash);
        myUser.setRole("User");
        authRepository.save(myUser);
    }
}