package cars.service;

import cars.home.Car;
import cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static final Logger logger = Logger.getLogger(CarService.class.getName());

    public Iterable<Car> findCars()
    {
        return carRepository.findAll();
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {
        Car car = carRepository.getOne(id);
        carRepository.deleteById(id);
        logger.log(Level.INFO,"Deleting : "+car.getName()+" Car From The UnSold List of Cars ");
    }

    public Car getCar(Integer id) {
        Car car =  carRepository.getOne(id);
        return car;
    }
}
