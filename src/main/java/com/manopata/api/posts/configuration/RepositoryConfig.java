package com.manopata.api.posts.configuration;


import com.manopata.api.posts.interfaces.dbo.PostDbo;
import com.manopata.api.posts.interfaces.repositories.JpaPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    private final JpaPostRepository jpaPostRepository;

    public RepositoryConfig(JpaPostRepository jpaPostRepository) {
        this.jpaPostRepository = jpaPostRepository;
    }

    @Bean
    public JpaPostRepository postRepository() {
        return new PostDbo(jpaPostRepository);
    }}
