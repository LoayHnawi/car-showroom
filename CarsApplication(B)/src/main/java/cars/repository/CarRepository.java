package cars.repository;

import cars.home.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
