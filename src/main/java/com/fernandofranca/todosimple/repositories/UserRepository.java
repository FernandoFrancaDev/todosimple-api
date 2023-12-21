package com.fernandofranca.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandofranca.todosimple.models.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    org.springframework.boot.autoconfigure.security.SecurityProperties.User save(
            org.springframework.boot.autoconfigure.security.SecurityProperties.User obj);   
    
}
