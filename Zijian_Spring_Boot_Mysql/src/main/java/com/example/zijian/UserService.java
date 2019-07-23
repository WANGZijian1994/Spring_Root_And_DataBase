package com.example.zijian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> insertT(){
        List<User>l = new ArrayList<User>();
        User u1 = new User();
        u1.setId(7);
        u1.setName("Jiaxin");
        u1.setPassword("Spurs");
        l.add(u1);
        User u2 = new User();
        u2.setId(8);
        u2.setName("XiaoMin");
        u2.setPassword("Utrecht");
        l.add(u2);
        User u3 = new User();
        u3.setId(9);
        u3.setName("Kashiwa");
        u3.setPassword("ReySol");
        l.add(u3);
        userRepository.saveAll(l);
        return l;
    }
}
