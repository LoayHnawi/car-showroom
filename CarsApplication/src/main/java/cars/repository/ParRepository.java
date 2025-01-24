package cars.repository;

import cars.home.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParRepository extends JpaRepository<Parameter,Integer> {
}
