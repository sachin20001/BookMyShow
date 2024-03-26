package org.example.book_my_show.exceptions;

public class UserAlreadyExists extends Exception{
    public  UserAlreadyExists() {
        super("Email is already registered");
    }
}
