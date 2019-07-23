package com.example.zijian;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer>{
    List<User> findByName(String name);
    List<User> findByPassword(String password);
}
