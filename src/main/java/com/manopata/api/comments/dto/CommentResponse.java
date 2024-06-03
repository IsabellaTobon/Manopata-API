package com.manopata.api.comments.dto;

import com.manopata.api.comments.interfaces.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse
{
    private String id;
    private String bodyText;
    private Integer likes;
    private String userId;
    private String postId;

    public CommentResponse (Comment model)
    {
        this.id = model.getId();
        this.bodyText = model.getBodyText();
        this.likes = model.getLikes();
        this.userId = model.getUserId();
        this.postId = model.getPostId();
    }
}
