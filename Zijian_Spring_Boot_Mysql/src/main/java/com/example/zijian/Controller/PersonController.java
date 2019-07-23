package com.example.zijian.Controller;

import com.example.zijian.Entity.Utilisateur;
import com.example.zijian.Repository.PersonRepository;
import com.example.zijian.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

//Entity doit partager le même nom que le tableau dans le Mysql Workbench

//1. id doit être ajouté à la main? Comment simplifier les étapes.
//2. NoBeanRepository 不让接口变实例化，si bien que一个接口能够继承多个仓库répertoire
//3. Jpa<Utilisateur,Integer(Long)> Il faut écrire Integer ou Long?

@RestController
public class PersonController{
    @Autowired
    private PersonRepository personRepository;

    //1 . Visualiser ce qui existe déjà 查看Mysql中已有的数据。

    @GetMapping(value = "/utilisateur")
    public List<Utilisateur> Total(){
        return personRepository.findAll();
    }

    //2. Ajouter une nouvelle personne 添加一个新人
    @RequestMapping("/utilisateur/append")///Utilisateur/append?name=Depay&age=25
    @ResponseBody
    public Utilisateur ajouter1(String name, Integer age){
        Utilisateur u = new Utilisateur();
        u.setId(6);
        u.setAge(age);
        u.setName(name);
        personRepository.save(u);
        return u;
    }

    //3. Ajouter beaucoup de personnes
    @Autowired
    private PersonService addMany;

    @PostMapping(value = "utilisateur/ajouterM")
    public List<Utilisateur> ajouterBeaucoup(){
        return addMany.Beaucoup();
    }

    //4. Supprimer une personne par un élément 通过一个指标（比如数字）删除一个人

    @Autowired
    private PersonRepository personRepository1;

    @DeleteMapping(value = "/utilisateur/{id}")
    public void supprimer1(@PathVariable("id") Integer id){
        List<Utilisateur>l = personRepository1.findAll();
        for(Utilisateur u : l){
            int identité = u.getId();
            if(identité==id){
                personRepository1.delete(u);
                break;
            }
        }
    }

    //5. Modifier des informations 改信息
    @Autowired
    private PersonRepository pr;

    @PostMapping(value = "/utilisateur/update/{id}")
    public Utilisateur renouveller(@PathVariable("id") Integer id,
                                   @RequestParam("name") String name,
                                   @RequestParam("age") Integer age){
        Utilisateur u = new Utilisateur();
        u.setName(name);
        u.setId(id);
        u.setAge(age);
        return pr.save(u);
    }

    //6. Mettre en ordre par l'indice <<âge>>

}
