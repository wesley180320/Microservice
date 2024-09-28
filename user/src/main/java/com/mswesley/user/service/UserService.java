package com.mswesley.user.service;

import com.mswesley.user.dtos.UserRecordDto;
import com.mswesley.user.models.EmailModel;
import com.mswesley.user.models.UserModel;
import com.mswesley.user.repository.UserRepository;
import org.eclipse.angus.mail.iap.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  EmailService emailService;

    public Boolean saveAll(UserRecordDto userRecordDto){
        if(userRepository.findByName(userRecordDto.name()).get().size() == 0 && userRepository.findByEmail(userRecordDto.email()).get().size() == 0 ){
            byte [] senhaCodificada = userRecordDto.senha().getBytes();
            Random rand = new Random();
            UserModel userModel = new UserModel();
            userModel.setName(userRecordDto.name());
            userModel.setEmail(userRecordDto.email());
            userModel.setSenha(senhaCodificada);
            userRepository.save(userModel);
            Integer codigo = rand.nextInt();
            EmailModel emailModel = new EmailModel(null, "teste","estevaoowesley@gmail.com",userRecordDto.email(), "CADASTRO CONCLUIDO COM SUCESSO","Olá usuário cadastrado com sucesso " + "Usuário: " +  userRecordDto.name() + " " + "Email: " + userRecordDto.email() + " " + "Protocolo: " + codigo.toString().replace("-", ""), LocalDate.now());
            emailService.sendEmail(emailModel);
            return true;
        }else {
            return false;
        }
    }

    public Boolean findUser(UserRecordDto userRecordDto){
        if(userRepository.findByName(userRecordDto.name()).get().size() != 0 && userRepository.findByEmail(userRecordDto.email()).get().size() != 0){
            System.out.println("Liberado " + userRecordDto.email() + userRecordDto.name());
            return true;
        }else {
            return false;
        }
    }

//    public void atualizar(UserRecordDto userRecordDto){
//        Optional<UserModel> m1 = userRepository.findByname(userRecordDto.name());
//        UserModel userModel = m1.get();
//        userModel.setEmail(userRecordDto.email());
//        userModel.setName(userRecordDto.name());
//        userRepository.save(userModel);
//    }

    public List<UserModel> findAll(){
        List<UserModel> users = userRepository.findAll();
        return users;
    }
}
