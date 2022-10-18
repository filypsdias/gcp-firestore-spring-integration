package cision.com.gcp.firestore.poc.user.repository;

import cision.com.gcp.firestore.poc.user.User;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends FirestoreReactiveRepository<User> {
  Flux<User> findByAge(int age);
}
