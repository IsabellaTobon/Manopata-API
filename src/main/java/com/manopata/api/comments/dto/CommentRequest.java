package com.manopata.api.comments.dto;

import com.manopata.api.comments.interfaces.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommentRequest {

    private String bodyText;
    private Integer likes;
    private String userId;
    private String postId;

    public Comment toModel (String id)
    {
        Comment model = new Comment();
        model.setId(id);
        model.setLikes(this.likes);
        model.setUserId(this.userId);
        model.setPostId(this.postId);

        return model;
    }
}
