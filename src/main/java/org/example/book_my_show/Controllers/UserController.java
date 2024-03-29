package org.example.book_my_show.Controllers;

import org.example.book_my_show.dtos.AddUserRequestDTO;
import org.example.book_my_show.dtos.AddUserResponseDTO;
import org.example.book_my_show.dtos.ResponseStatus;
import org.example.book_my_show.models.User;
import org.example.book_my_show.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public AddUserResponseDTO addUser(AddUserRequestDTO addUserRequestDTO)
    {
        AddUserResponseDTO addUserResponseDTO=new AddUserResponseDTO();

        try
        {
            User user=userService.addUser(addUserRequestDTO.getUsername(),addUserRequestDTO.getEmail(),addUserRequestDTO.getPassword());

            addUserResponseDTO.setUserId(user.getId());
            addUserResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            addUserResponseDTO.setMessage("User Successfully Added");

        }
        catch (Exception ex)
        {
            addUserResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            addUserResponseDTO.setMessage("Something went wrong");
            //Log the error
        }
        return addUserResponseDTO;
    }






}
