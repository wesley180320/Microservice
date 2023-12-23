package com.mswesley.user.controller;

import com.mswesley.user.dtos.UserRecordDto;
import com.mswesley.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid UserRecordDto userRecordDto){
        if(userService.saveAll(userRecordDto) == null){
            return  ResponseEntity.ok().body("Usuario cadastrado com sucesso" + userRecordDto.name() + " " + userRecordDto.email());
        }
        return ResponseEntity.badRequest().body(userService.saveAll(userRecordDto));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> findUser(@RequestBody UserRecordDto userRecordDto){
        if(userService.findUser(userRecordDto) != null){
            return  ResponseEntity.ok().body("Liberado");
        }
        return ResponseEntity.badRequest().body("Nao liberado");
    }

    @RequestMapping(value = "/updateEmail", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody UserRecordDto userRecordDto){
        userService.atualizar(userRecordDto);
        return ResponseEntity.ok().body("Email alterado com sucesso");
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<Object> findALl(){
        return ResponseEntity.ok().body(userService.findAll());
    }
}
