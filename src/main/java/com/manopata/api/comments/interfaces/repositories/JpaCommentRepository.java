package com.manopata.api.comments.interfaces.repositories;

import com.manopata.api.comments.interfaces.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCommentRepository extends JpaRepository<Comment, String> {
}
