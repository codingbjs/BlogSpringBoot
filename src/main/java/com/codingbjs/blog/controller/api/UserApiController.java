package com.codingbjs.blog.controller.api;

import com.codingbjs.blog.dto.ResponseDto;
import com.codingbjs.blog.model.RoleType;
import com.codingbjs.blog.model.User;
import com.codingbjs.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        user.setRole(RoleType.USER);
        int result = userService.joinUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }
}
