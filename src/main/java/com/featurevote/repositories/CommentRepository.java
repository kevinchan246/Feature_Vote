package com.featurevote.repositories;

import com.featurevote.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByFeatureId(Long featureId);
}
