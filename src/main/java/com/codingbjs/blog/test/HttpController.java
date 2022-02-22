package com.codingbjs.blog.test;

import org.springframework.web.bind.annotation.*;


@RestController
public class HttpController {

//    Member m = Member.builder().username("홍길동").build();


//    @GetMapping("/http/get")
//    public String getTest(@RequestParam int id, @RequestParam String username) {
//        return "Get 요청 : " + id + ", " + username;
//    }

    @GetMapping("/http/get")
    public String getTest(Member member) {
        return "Get 요청 : " + member.toString();
    }


//    @PostMapping("/http/post") // html form
//    public String postTest(Member member) {
//        return "Post 요청 : " + member.toString();
//    }

//    @PostMapping("/http/post") // text/plain
//    public String postTest(@RequestBody String text) {
//        return "Post 요청 : " + text;
//    }

    @PostMapping("/http/post") // application/json
    public String postTest(@RequestBody Member member) {
        return "Post 요청 : " + member.toString();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member member) {
        return "Put 요청 : " + member.toString();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(@RequestBody Member member) {
        return "Delete 요청 : " + member.toString();
    }

}
