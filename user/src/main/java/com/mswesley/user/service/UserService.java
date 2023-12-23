package com.mswesley.user.service;

import com.mswesley.user.dtos.UserRecordDto;
import com.mswesley.user.models.UserModel;
import com.mswesley.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String saveAll(UserRecordDto userRecordDto){
        if(userRepository.findByname(userRecordDto.name()).isEmpty() && userRepository.findByemail(userRecordDto.email()).isEmpty()){
            UserModel userModel = new UserModel();
            userModel.setName(userRecordDto.name());
            userModel.setEmail(userRecordDto.email());
            userRepository.save(userModel);
        }else{
            System.out.println("Usuário ja existe");
            return "Usuário ou Email já existe";
        }
        return null;
    }

    public String findUser(UserRecordDto userRecordDto){
        if(userRepository.findByname(userRecordDto.name()).isPresent() && userRepository.findByemail(userRecordDto.email()).isPresent()){
            System.out.println("Liberado " + userRecordDto.email() + userRecordDto.name());
            return "Liberado";
        }else {
            System.out.println("Usuário nao existe");
            return "Usuário ou Email nao existe";
        }
    }

    public void atualizar(UserRecordDto userRecordDto){
        Optional<UserModel> m1 = userRepository.findByname(userRecordDto.name());
        UserModel userModel = m1.get();
        userModel.setEmail(userRecordDto.email());
        userModel.setName(userRecordDto.name());
        userRepository.save(userModel);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }
}
