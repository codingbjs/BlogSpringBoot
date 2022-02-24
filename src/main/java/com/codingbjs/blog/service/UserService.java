package com.codingbjs.blog.service;

import com.codingbjs.blog.model.User;
import com.codingbjs.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int joinUser(User user){
        try {
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
