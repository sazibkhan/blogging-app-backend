package com.ddtp.controller;

import com.ddtp.dto.request.UserRequest;
import com.ddtp.dto.response.UserResponse;
import com.ddtp.entity.User;
import com.ddtp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/blogging")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/insert")
    public ResponseEntity<User> insertUser(@RequestBody UserRequest userRequest ){
        return new ResponseEntity(userService.insertUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/user/get/allInformation")
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return new ResponseEntity(userService.getAllUserInformation(),HttpStatus.OK) ;
    }

    @GetMapping("/user/get/allInformation/by/{id}")
    public ResponseEntity<UserResponse>getUserByUserId(@PathVariable String id){
        return new ResponseEntity(userService.getUserInformationById(id),HttpStatus.OK);
    }

    @PutMapping("/user/get/Information/updateBy/{id}")
    public ResponseEntity <Void> getUserUpdateByUserId(@RequestBody UserRequest userRequest,@PathVariable String id){
        userService.updateUserInformationById(id,userRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/Information/by/{id}")
    public ResponseEntity<Void> deleteUserByUserId(@PathVariable String id){
        return new ResponseEntity(userService.deleteUserInformationBy(id),HttpStatus.NO_CONTENT);
    }



}
