import cars.DataApplication;
import cars.home.Car;
import cars.home.Parameter;
import cars.repository.CarRepository;
import cars.repository.ParRepository;
import cars.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = DataApplication.class)
@Transactional
class DataApplicationTests {

	@Resource
	private CarRepository carRepository;

	@MockBean
	private ParRepository parRepository;

	@Test
	public void  WhenSaveCar_ReturnCarTest() {

		Parameter parameter1 = new Parameter("num_disk", 4);

		List<Parameter> data = Arrays.asList(parameter1);

		given(parRepository.findById(anyInt())).willReturn(Optional.ofNullable(parameter1));

		Car car = new Car("BM", 50.0, 0,data);
		if (car.getNum_disk() == 0) {
			car.setNum_disk(data.get(0).getValue());
		}

		carRepository.save(car);
		Car car1 = carRepository.findByName("BM");
		Assert.assertEquals("BM", car1.getName());
	}

	@Test
	public void WhenDeleteCar_ReturnCarTest() {
		Car car =carRepository.findByName("BM");
		carRepository.delete(car);
		Assert.assertEquals(false,carRepository.existsById(car.getId()));
	}

	@Test
	public void WhenUpdateCar_ReturnCarTest() {
		Car car = carRepository.findByName("BM");
		Car car1 = new Car("lamborghini", car.getPrice(), car.getNum_disk(),car.getParameters());
		carRepository.save(car1);
		carRepository.delete(car);

		Assert.assertEquals(false,carRepository.existsById(car.getId()));
		Assert.assertEquals(true,carRepository.existsById(car1.getId()));
	}

}
