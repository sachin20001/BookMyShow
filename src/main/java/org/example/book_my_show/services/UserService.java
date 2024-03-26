package org.example.book_my_show.services;

import org.example.book_my_show.models.User;
import org.example.book_my_show.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepo userRepo;


    @Autowired
    public UserService(UserRepo userRepo)
    {
        this.userRepo=userRepo;
    }

    public User addUser(String username,String email,String password)
    {
        //Check if email Already exist
        // if yess throe custome errior or else create the user

        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        User savedUser=userRepo.save(user);
        return savedUser;
    }
}
