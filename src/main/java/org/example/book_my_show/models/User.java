package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Base {
    private String username;
    private String email;
    private String password;
}
