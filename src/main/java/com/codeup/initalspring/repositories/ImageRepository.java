package com.codeup.initalspring.repositories;

import com.codeup.initalspring.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<PostImage, Long> {
}
