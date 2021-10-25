package com.ddtp.repository;


import com.ddtp.entity.BlogPost;
import com.ddtp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepository  extends JpaRepository<BlogPost,String>{

    Optional<BlogPost> findAllById(String id);

}
