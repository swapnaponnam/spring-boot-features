package com.spring.springbootfeatures.controller;

import com.spring.springbootfeatures.pojo.User;
import com.spring.springbootfeatures.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        System.out.println("post end point ===============");
        for(MultipartFile file : files){
            userService.saveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(value = "/users",produces="application/json" )
    public CompletableFuture<ResponseEntity> findALlUsers(){
        return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }
    @GetMapping("/getUsersByThread")
    public ResponseEntity getUsersByThread(){
        CompletableFuture<List<User>> users1 = userService.findAllUsers();
        CompletableFuture<List<User>> users2 = userService.findAllUsers();
        CompletableFuture<List<User>> users3 = userService.findAllUsers();
        CompletableFuture.allOf(users1,users2,users3).join();
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
