package cl.janodevg.ms.mscustomer.controllers;

import cl.janodevg.ms.mscustomer.models.entity.User;
import cl.janodevg.ms.mscustomer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/all")
    public List<User> users(){
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        Optional<User> byId = service.findById(id);
        return byId.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userRequest){
        Optional<User> user = service.findById(id);
        if (user.isPresent()){
            User userDB= user.get();
            userDB.setEmail(userRequest.getEmail());
            userDB.setName(userDB.getName());
            userDB.setPassword(userRequest.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userDB));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id){
        Optional<User> user = service.findById(id);
        if (user.isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
