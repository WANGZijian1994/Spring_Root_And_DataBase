package com.example.zijian.Repository;

import com.example.zijian.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Utilisateur,Integer>{
}
