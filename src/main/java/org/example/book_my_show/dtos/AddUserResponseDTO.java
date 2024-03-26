package org.example.book_my_show.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserResponseDTO extends BaseResponse {
    private Long userId;
}
