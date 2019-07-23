package com.example.zijian.Service;


import com.example.zijian.Entity.Utilisateur;
import com.example.zijian.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Utilisateur Construction(Utilisateur u,int id, int age,String name){
        u.setAge(age);
        u.setId(id);
        u.setName(name);
        return u;
    }

    public List<Utilisateur> Beaucoup() {
        Utilisateur u1 = new Utilisateur();
        Utilisateur u2 = new Utilisateur();
        Utilisateur u3 = new Utilisateur();
        Utilisateur u4 = new Utilisateur();
        u1 = Construction(u1,7,23,"HaoYu");
        u2 = Construction(u2,8,24,"Mingjun");
        u3 = Construction(u3,9,28,"Dindin");
        u4 = Construction(u4,10,56,"Claude Montacié");
        List<Utilisateur>l = new ArrayList<Utilisateur>();
        l.add(u1);l.add(u2);l.add(u3);l.add(u4);
        personRepository.saveAll(l);
        return l;
    }
}
