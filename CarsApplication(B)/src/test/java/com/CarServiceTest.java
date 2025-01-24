package com;

import cars.home.*;
import cars.repository.CarRepository;
import cars.repository.ParRepository;
import cars.service.CarService;
import cars.service.ParService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

    import static org.mockito.BDDMockito.*;
    import static org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

//    @MockBean
//    private CarRepository carRepository;

    @MockBean
    private ParRepository parRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private ParService  parService;

    @TestConfiguration
    static class CarServiceContextConfiguration{
        @Bean
        public CarService carService() {
            return new CarService();
        }
    }

    @TestConfiguration
    static class ParServiceContextConfiguration{
        @Bean
        public ParService parService() {
            return new ParService();
        }
    }

    @Test
    public void whenSaveCar_ReturnCarTest()
    {
        Parameter parameter1 = new Parameter(1,"num_disk",4);
        Parameter parameter2 = new Parameter(2,"num_disk",4);

        Car car1 = new Car(1,"BMW",500.0,4);
        Car car2 = new Car(2,"BM",400.0,6);

        List<Parameter> data = Arrays.asList(parameter1,parameter2);

        given(parRepository.findById(anyInt())).willReturn(Optional.ofNullable(parameter1));

        assertThat(carService.findCars())
                    .hasSize(2)
                    .contains(car1,car2);

    }


}
