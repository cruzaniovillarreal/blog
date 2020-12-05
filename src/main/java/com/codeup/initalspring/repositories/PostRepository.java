package com.codeup.initalspring.repositories;

import com.codeup.initalspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("FROM Post p WHERE p.title LIKE %:search% OR p.body LIKE %:search%")
    List<Post> findPostsByTitleContainingOrBodyContaining(@Param("search") String search);
}
