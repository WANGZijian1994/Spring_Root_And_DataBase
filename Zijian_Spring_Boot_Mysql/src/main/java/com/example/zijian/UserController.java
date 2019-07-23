package com.example.zijian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //计入Mysql表格
    @GetMapping(value = "/user")
    public List<User> userList(){return userRepository.findAll();}

    //增加一个新人

    @RequestMapping("/user/addOne")
    @ResponseBody
    public User addUser(Integer id,String name,String password){
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setName(name);
        userRepository.save(user);
        return user;
    }


    //通过ID查看某个元素
    @GetMapping(value = "/user/{id}")
    public User findUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }


    //增添n个新元素
    @Autowired
    UserService userService;

    @PostMapping (value = "/user/addTwo")
    public List<User> insert(){return userService.insertT();}
}
