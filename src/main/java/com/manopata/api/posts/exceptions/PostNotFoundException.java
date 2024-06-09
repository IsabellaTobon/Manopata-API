package com.manopata.api.posts.exceptions;

public class PostNotFoundException extends RuntimeException
{
    public PostNotFoundException(String message) {
        super(message);
    }
}
