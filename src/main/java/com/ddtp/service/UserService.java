package com.ddtp.service;

import com.ddtp.dto.request.UserRequest;
import com.ddtp.dto.response.UserResponse;
import com.ddtp.entity.User;
import com.ddtp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository ;

    public User insertUser(UserRequest userRequest) {

        User user = new User();

        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setApproval(userRequest.getApproval());
        user.setApprovalAt(userRequest.getApprovalAt());
        user.setApprovalBy(userRequest.getApprovalBy());
        user.setCreatedAt(userRequest.getCreatedAt());
        user.setCreatedBy(userRequest.getCreatedBy());
        user.setUpdatedAt(userRequest.getUpdatedAt());
        user.setUpdateBy(userRequest.getUpdateBy());

        userRepository.saveAndFlush(user);
        return user;
    }


  public List<UserResponse> getAllUserInformation(){

        List<UserResponse> userResponseList = new ArrayList<>();
        List<User>userList = userRepository.findAll();
        userList = userRepository.findAll();

        for (User user : userList){

            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setUsername(user.getUsername());
            userResponse.setEmail(user.getEmail());
            userResponse.setApproval(user.getApproval());
            userResponse.setCreatedAt(user.getCreatedAt());

            userResponseList.add(userResponse);
        }
        return userResponseList;
    }



    public UserResponse getUserInformationById(String id){

        Optional<User> optionalUserPanel = userRepository.findAllById(id);

        if (!optionalUserPanel.isPresent()){
            throw new RuntimeException("User Id Not Present");
        }

       User user=optionalUserPanel.get();

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .approval(user.getApproval())
                .build();
    }


    public void updateUserInformationById(String id, UserRequest userRequest) {

        Optional<User> optionalUserPanel = userRepository.findAllById(id);

        if (!optionalUserPanel.isPresent()){
            throw new RuntimeException("User Id Not Present");
        }

        User user=optionalUserPanel.get();

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setApproval(userRequest.getApproval());

        userRepository.save(user);
    }


    public ResponseEntity<Void> deleteUserInformationBy(String id){

        Optional<User> optionalUserPanel = userRepository.findAllById(id);

        if (!optionalUserPanel.isPresent()){
            throw new RuntimeException("User Id Not Present");
        }
        User user = optionalUserPanel.get();
        userRepository.delete(user);

        return null;
    }

}




