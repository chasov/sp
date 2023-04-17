package edu.rd.spcity.controller;


import edu.rd.spcity.model.User;
import edu.rd.spcity.service.UserClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/client/users")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserClientController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{userId}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String userId) {
        Mono<User> user = userClient.getUser(userId);
        return user.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userClient.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        return userClient.createUser(user);
    }


}
