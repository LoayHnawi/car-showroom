package cars.repository;

import cars.home.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findBynameUser(String nameUser);
}
