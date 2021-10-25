package com.ddtp.repository;

import com.ddtp.entity.BlogPostReact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostReactRepository extends JpaRepository<BlogPostReact,String> {
    Optional<BlogPostReact> findAllById(String id);

}
