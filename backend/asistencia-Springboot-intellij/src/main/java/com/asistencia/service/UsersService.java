package com.asistencia.service;

import com.asistencia.Entity.Users;
import com.asistencia.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UsersService {

    private final UserRepository userRepository;

    public Iterable<Users> findAll(){
        return userRepository.findAll();
    }

    public Users findById( Integer id){
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public Users create(Users users){
        users.setCreateAt(LocalDateTime.now());
        return userRepository.save(users);
    }
    public Users update( Integer id, Users form){
        Users usersFromDB = findById(id);
        usersFromDB.setName(form.getName());
        usersFromDB.setLastName(form.getLastName());
        usersFromDB.setEmail(form.getEmail());

        return userRepository.save(usersFromDB);
    }
    public void delete(Integer id){
        Users usersFromDB = findById(id);
        userRepository.delete(usersFromDB);
    }


}
