package com.ddtp.controller;

import com.ddtp.dto.request.BlogPostReactRequest;
import com.ddtp.dto.response.BlogPostReactResponse;
import com.ddtp.dto.response.UserResponse;
import com.ddtp.entity.BlogPostReact;
import com.ddtp.service.BlogPostReactService;
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
public class BlogPostReactController {

    private final BlogPostReactService blogPostReactService;

    @PostMapping("/blogPostReact/insert")
    public ResponseEntity<BlogPostReact> insertBlogPostReact(@RequestBody BlogPostReactRequest blogPostReactRequest  ){
        return new ResponseEntity(blogPostReactService.insertBlogPostReact(blogPostReactRequest), HttpStatus.CREATED);
    }

    @GetMapping("/blogPostReact/get/allInformation")
    public ResponseEntity<List<BlogPostReactResponse>> getAllBlogPostReact(){
        return new ResponseEntity(blogPostReactService.getAllBlogPostReactInformation(),HttpStatus.OK) ;
    }

    @GetMapping("/blogPostReact/get/allInformation/by/{id}")
    public ResponseEntity<UserResponse>getBlogPostReactByBlogPostReactId(@PathVariable String id){
        return new ResponseEntity(blogPostReactService.getBlogPostReactInformationById(id),HttpStatus.OK);
    }

    @PutMapping("/blogPostReact/get/Information/updateBy/{id}")
    public ResponseEntity <Void> getBlogPostReactUpdateByBlogPostReactId(@RequestBody BlogPostReactRequest blogPostReactRequest, @PathVariable String id){
        blogPostReactService.updateBlogPostReactInformationById(id,blogPostReactRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/blogpost/delete/Information/by/{id}")
    public ResponseEntity<Void> deleteBlogPostReactByBlockPostReactId(@PathVariable String id){
        return new ResponseEntity(blogPostReactService.deleteBlogPostReactInformationBy(id),HttpStatus.NO_CONTENT);
    }


}
