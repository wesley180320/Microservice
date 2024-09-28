package com.mswesley.user.controller;

import com.mswesley.user.dtos.EmailDto;
import com.mswesley.user.dtos.UserRecordDto;
import com.mswesley.user.models.EmailModel;
import com.mswesley.user.service.EmailService;
import com.mswesley.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid UserRecordDto userRecordDto){
        if(userService.saveAll(userRecordDto) == true){
            return  ResponseEntity.ok().body("Usuario cadastrado com sucesso " + userRecordDto.name() + " " + userRecordDto.email());
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> findUser(@RequestBody UserRecordDto userRecordDto){
        if(userService.findUser(userRecordDto) == true){
            return  ResponseEntity.ok().body("Liberado");
        }
        return ResponseEntity.badRequest().body("Nao liberado");
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<Object> findALl(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
