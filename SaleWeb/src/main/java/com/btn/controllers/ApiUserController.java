package com.btn.controllers;

import com.btn.pojo.User;
import com.btn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiUserController {
    //bawm mat khau
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @PostMapping(path = "/users/", consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file)
    {
        User u =new User();
        u.setFirstName(params.get("firstName"));
        u.setLastName(params.get("lastName"));
        u.setUserRole("ROLE_USER"); // default
        u.setUsername(params.get("username"));
        u.setEmail(params.get("email"));
        u.setPhone(params.get("phone"));
        u.setActive(true);
        // password phai bam mat khau
        String password = params.get("password");
        u.setPassword(this.passwordEncoder.encode(password));

        // neu co gui file len
        if(file.length > 0)
        {
            u.setFile(file[0]);
        }
        this.userService.addUser(u);
    }
}
