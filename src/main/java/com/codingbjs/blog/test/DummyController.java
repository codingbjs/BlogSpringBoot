package com.codingbjs.blog.test;

import com.codingbjs.blog.model.RoleType;
import com.codingbjs.blog.model.User;
import com.codingbjs.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyController {

    @Autowired
    private UserRepository userRepository;


//    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email){
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("email = " + email);
//        return "회원가입 완료";
//    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("user = " + user.toString());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }

    //{id} 주소로 파라미터를 전달받을 수 있다.
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 사용자가 없습니다. id : " + id);
            }
        });

        return user;
    }

    @GetMapping("/dummy/user")
    public List<User> userList() {
        return userRepository.findAll();
    }


//    http://localhost:8000/blog/dummy/user/page?page=1
    @GetMapping("/dummy/user/page")
    public Page<User> pageList(@PageableDefault(
            size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> userList = userPage.getContent();
        return userPage;
    }

    @Transactional // 더티체킹으로 User 객체의 수정이 생기면 메소드 종료 시점에서 자동으로 DB 에 데이터를 업데이트한다.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("수정실패");
            }
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(user);     @Transactional 을 사용하면 save 할필요없음.
        return user;
    }

    @DeleteMapping("/dummy/user/{id}")
    public String deleteUser (@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            return "삭제 실패 id = " + id;
        }

        return "삭제되었습니다. id = " + id;
    }

}
