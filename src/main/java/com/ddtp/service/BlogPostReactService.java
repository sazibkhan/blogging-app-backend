package com.ddtp.service;

import com.ddtp.dto.request.BlogPostReactRequest;
import com.ddtp.dto.request.BlogPostRequest;
import com.ddtp.dto.response.BlogPostReactResponse;
import com.ddtp.dto.response.BlogPostResponse;
import com.ddtp.entity.BlogPost;
import com.ddtp.entity.BlogPostReact;
import com.ddtp.repository.BlogPostReactRepository;
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
public class BlogPostReactService {

    private final BlogPostReactRepository blogPostReactRepository;

    public BlogPostReact insertBlogPostReact(BlogPostReactRequest blogPostReactRequest) {

        BlogPostReact blogPostReact = new BlogPostReact();

        String uuid = UUID.randomUUID().toString();
        blogPostReact.setId(uuid);

        blogPostReact.setReactType(blogPostReactRequest.getReactType());
        blogPostReact.setApproval(blogPostReactRequest.getApproval());

        blogPostReact.setApprovalAt(blogPostReactRequest.getApprovalAt());
        blogPostReact.setApprovalBy(blogPostReactRequest.getApprovalBy());
        blogPostReact.setCreatedAt(blogPostReactRequest.getCreatedAt());
        blogPostReact.setCreatedBy(blogPostReactRequest.getCreatedBy());
        blogPostReact.setUpdateAt(blogPostReactRequest.getUpdateAt());
        blogPostReact.setUpdateBy(blogPostReactRequest.getUpdateBy());

        blogPostReactRepository.saveAndFlush(blogPostReact);
        return blogPostReact;
    }

    public List<BlogPostReactResponse> getAllBlogPostReactInformation(){

        List<BlogPostReactResponse> blogPostReactResponseList = new ArrayList<>();
        List<BlogPostReact>blogPostReactList = blogPostReactRepository.findAll();
        blogPostReactList = blogPostReactRepository.findAll();

        for (BlogPostReact blogPostReact : blogPostReactList){

            BlogPostReactResponse blogPostReactResponse = new BlogPostReactResponse();

            blogPostReactResponse.setId(blogPostReact.getId());
            blogPostReactResponse.setReactType(blogPostReact.getReactType());
            blogPostReactResponse.setApproval(blogPostReact.getApproval());
            blogPostReactResponse.setApproval(blogPostReact.getApproval());
            blogPostReactResponse.setCreatedAt(blogPostReact.getCreatedAt());

            blogPostReactResponseList.add(blogPostReactResponse);
        }
        return blogPostReactResponseList;
    }

    public BlogPostReactResponse getBlogPostReactInformationById(String id){

        Optional<BlogPostReact> optionalBlogPostReact = blogPostReactRepository.findAllById(id);

        if (!optionalBlogPostReact.isPresent()){
            throw new RuntimeException("BlogPostReact Id Not Present");
        }
        BlogPostReact blogPostReact=optionalBlogPostReact.get();

        return BlogPostReactResponse.builder()
                .id(blogPostReact.getId())
                .reactType(blogPostReact.getReactType())
                .approval(blogPostReact.getApproval())
                .build();
    }

    public void updateBlogPostReactInformationById(String id, BlogPostReactRequest blogPostReactRequest) {

        Optional<BlogPostReact> optionalBlogPostReact = blogPostReactRepository.findAllById(id);

        if (!optionalBlogPostReact.isPresent()){
            throw new RuntimeException("BlogPost React Id Not Present");
        }

        BlogPostReact blogPostReact=optionalBlogPostReact.get();

        blogPostReact.setReactType(blogPostReactRequest.getReactType());
        blogPostReact.setApproval(blogPostReactRequest.getApproval());

        blogPostReactRepository.save(blogPostReact);
    }

    public ResponseEntity<Void> deleteBlogPostReactInformationBy(String id){

        Optional<BlogPostReact> optionalBlogPostReact = blogPostReactRepository.findAllById(id);

        if (!optionalBlogPostReact.isPresent()){
            throw new RuntimeException("BlogPost Id Not Present");
        }

        BlogPostReact blogPostReact = optionalBlogPostReact.get();
        blogPostReactRepository.delete(blogPostReact);

        return null;
    }





}
