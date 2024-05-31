package com.asistencia.Controller;


import com.asistencia.Entity.Users;
import com.asistencia.repository.UserRepository;
import com.asistencia.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
//<>

    private final UsersService usersService;

    @GetMapping
    public Iterable<Users> list(){
        return usersService.findAll();
    }

    @GetMapping("{id}")
    public Users get(@PathVariable Integer id){
        return usersService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Users create(@RequestBody Users users){
        return usersService.create(users);
    }

    @PutMapping("{id}")
    public Users update(@PathVariable Integer id,
                        @RequestBody Users form){
        return usersService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        usersService.delete(id);
    }


}
