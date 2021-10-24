package com.ddtp.service;

import com.ddtp.dto.request.BlogPostRequest;
import com.ddtp.dto.response.BlogPostResponse;
import com.ddtp.entity.BlogPost;
import com.ddtp.repository.BlogPostRepository;
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
public class BlogPostService {

    private  final BlogPostRepository blogPostRepository;

    public BlogPost insertBlogPost(BlogPostRequest blogPostRequest) {

        BlogPost blogPost = new BlogPost();

        String uuid = UUID.randomUUID().toString();
        blogPost.setId(uuid);

        blogPost.setBlogPostTitle(blogPostRequest.getBlogPostTitle());
        blogPost.setBlogPostBody(blogPostRequest.getBlogPostBody());
        blogPost.setApproval(blogPostRequest.getApproval());

        blogPost.setApprovalAt(blogPostRequest.getApprovalAt());
        blogPost.setApprovalBy(blogPostRequest.getApprovalBy());
        blogPost.setCreatedAt(blogPostRequest.getCreatedAt());
        blogPost.setCreatedBy(blogPostRequest.getCreatedBy());
        blogPost.setUpdateAt(blogPostRequest.getUpdateAt());
        blogPost.setUpdateBy(blogPostRequest.getUpdateBy());

        blogPostRepository.saveAndFlush(blogPost);
        return blogPost;
    }

    public List<BlogPostResponse> getAllBlogPostInformation(){

        List<BlogPostResponse> blogPostResponseList = new ArrayList<>();
        List<BlogPost>blogPostList = blogPostRepository.findAll();
        blogPostList = blogPostRepository.findAll();

        for (BlogPost blogPost : blogPostList){

            BlogPostResponse blogPostResponse = new BlogPostResponse();

            blogPostResponse.setId(blogPost.getId());
            blogPostResponse.setBlogPostTitle(blogPost.getBlogPostTitle());
            blogPostResponse.setBlogPostBody(blogPost.getBlogPostBody());
            blogPostResponse.setApproval(blogPost.getApproval());
            blogPostResponse.setCreatedAt(blogPost.getCreatedAt());

            blogPostResponseList.add(blogPostResponse);
        }
        return blogPostResponseList;
    }

    public BlogPostResponse getBlogPostInformationById(String id){

        Optional<BlogPost> optionalUserPanel = blogPostRepository.findAllById(id);

        if (!optionalUserPanel.isPresent()){
            throw new RuntimeException("BlogPost Id Not Present");
        }
        BlogPost blogPost=optionalUserPanel.get();

        return BlogPostResponse.builder()
                .id(blogPost.getId())
                .blogPostTitle(blogPost.getBlogPostTitle())
                .blogPostBody(blogPost.getBlogPostBody())
                .approval(blogPost.getApproval())
                .build();
    }

    public void updateBlogPostInformationById(String id, BlogPostRequest blogPostRequest) {

        Optional<BlogPost> optionalBlogPostPanel = blogPostRepository.findAllById(id);

        if (!optionalBlogPostPanel.isPresent()){
            throw new RuntimeException("BlogPost Id Not Present");
        }

        BlogPost blogPost=optionalBlogPostPanel.get();
        blogPost.setBlogPostTitle(blogPostRequest.getBlogPostTitle());
        blogPost.setBlogPostBody(blogPostRequest.getBlogPostBody());
        blogPost.setApproval(blogPostRequest.getApproval());

        blogPostRepository.save(blogPost);
    }

    public ResponseEntity<Void> deleteBlogPostInformationBy(String id){

        Optional<BlogPost> optionalBlogPostPanel = blogPostRepository.findAllById(id);

        if (!optionalBlogPostPanel.isPresent()){
            throw new RuntimeException("BlogPost Id Not Present");
        }

        BlogPost blogPost = optionalBlogPostPanel.get();
        blogPostRepository.delete(blogPost);

        return null;
    }





}
