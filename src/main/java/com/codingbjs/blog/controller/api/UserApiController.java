package com.codingbjs.blog.controller.api;

import com.codingbjs.blog.dto.ResponseDto;
import com.codingbjs.blog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){

        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }
}
