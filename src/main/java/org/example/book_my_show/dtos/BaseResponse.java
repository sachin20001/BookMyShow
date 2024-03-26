package org.example.book_my_show.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {
    private ResponseStatus responseStatus;
    private String message;
}
