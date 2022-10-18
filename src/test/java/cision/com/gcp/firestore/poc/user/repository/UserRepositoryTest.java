package cision.com.gcp.firestore.poc.user.repository;

import cision.com.gcp.firestore.poc.user.User;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void testUserRepository() {
    userRepository.deleteAll();
    User.UserBuilder builder = User.builder()
        .name("Filipe")
        .age(23)
        .pets(Collections.singletonList(2));

    userRepository.save(builder.build()).block();
    userRepository.save(builder.name("Diaz").build()).block();
    userRepository.save(builder.age(18).build()).block();
    userRepository.save(builder.pets(Collections.singletonList(3)).build()).block();

    Flux<User> all = userRepository.findAll();
    all.doOnNext(
            user -> {
              System.out.println("Yes we got a ship: " + user);
            }
        ).doOnComplete(() -> System.out.println("We are done!"))
        .blockLast();
  }

}
