package vn.tuanjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import vn.tuanjava.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
