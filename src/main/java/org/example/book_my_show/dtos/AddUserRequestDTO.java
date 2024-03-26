package org.example.book_my_show.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequestDTO {
    private String username;
    private String email;
    private String password;
}
