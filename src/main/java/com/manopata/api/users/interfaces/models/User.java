package com.manopata.api.users.interfaces.models;

import com.manopata.api.comments.interfaces.models.Comment;
import com.manopata.api.posts.interfaces.models.Post;
import com.manopata.api.roles.interfaces.models.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String lastname;
    private String nickname;
    private String password;
//    private String role;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "name")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts; // Relation 1:N

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments; // Relation 1:N

    public User(String userId) {
    }
}
