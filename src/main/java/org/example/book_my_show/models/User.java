package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class User extends Base {
    private String username;
    private String email;
    private String password;
}
