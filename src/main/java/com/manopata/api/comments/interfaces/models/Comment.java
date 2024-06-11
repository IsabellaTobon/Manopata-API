package com.manopata.api.comments.interfaces.models;

import com.manopata.api.posts.interfaces.models.Post;
import com.manopata.api.users.interfaces.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private String id;
    private String bodyText;
    private int likes = 0;
//    private String userId;
//    private String postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // Relation N:1

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post; // Relation N:1
}
