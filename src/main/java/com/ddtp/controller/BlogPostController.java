package com.ddtp.controller;

import com.ddtp.dto.request.BlogPostRequest;
import com.ddtp.dto.response.UserResponse;
import com.ddtp.entity.User;
import com.ddtp.service.BlogPostService;
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
public class BlogPostController {

    private final BlogPostService blogPostService;

    @PostMapping("/blogpost/insert")
    public ResponseEntity<User> insertUser(@RequestBody BlogPostRequest blogPostRequest ){
        return new ResponseEntity(blogPostService.insertBlogPost(blogPostRequest), HttpStatus.CREATED);
    }

    @GetMapping("/blogpost/get/allInformation")
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return new ResponseEntity(blogPostService.getAllBlogPostInformation(),HttpStatus.OK) ;
    }

    @GetMapping("/blogpost/get/allInformation/by/{id}")
    public ResponseEntity<UserResponse>getBlogPostByBlogPostId(@PathVariable String id){
        return new ResponseEntity(blogPostService.getBlogPostInformationById(id),HttpStatus.OK);
    }

    @PutMapping("/blogpost/get/Information/updateBy/{id}")
    public ResponseEntity <Void> getBlogPostUpdateByUserId(@RequestBody BlogPostRequest blogPostRequest, @PathVariable String id){
        blogPostService.updateBlogPostInformationById(id,blogPostRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/blogpost/delete/Information/by/{id}")
    public ResponseEntity<Void> deleteBlogPostByUserId(@PathVariable String id){
        return new ResponseEntity(blogPostService.deleteBlogPostInformationBy(id),HttpStatus.NO_CONTENT);
    }








}
