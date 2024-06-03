package com.manopata.api.comments.interfaces.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Comment
{
    private String id;
    private String bodyText;
    private Integer likes;
    private String userId;
    private String postId;
}
