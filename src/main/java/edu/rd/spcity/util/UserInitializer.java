package edu.rd.spcity.util;


import edu.rd.spcity.model.User;
import edu.rd.spcity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;


@Component
@Profile("!test")
@Slf4j
public class UserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        initialDataSetup();
    }

    private List<User> getData() {
        return Arrays.asList(new User(null, "login1", 30),
                new User(null, "login2", 5),
                new User(null, "login3", 40));
    }

    private void initialDataSetup() {
        userRepository.deleteAll()
                .thenMany(Flux.fromIterable(getData()))
                .flatMap(userRepository::save)
                .thenMany(userRepository.findAll())
                .subscribe(user -> {
                    log.info("User Inserted from CommandLineRunner " + user);
                });

    }

}
