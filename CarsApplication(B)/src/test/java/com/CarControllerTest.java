package com;

import cars.home.*;
import cars.repository.ParRepository;
import cars.service.CarService;
import cars.service.ParService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private CarService carService;

    @MockBean
    private ParService parService;

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
        Parameter parameter1 = new Parameter("num_disk",4);

        Car car1 = new Car(1,"BMW",500.0,4);
//        Car car2 = new Car(2,"BM",400.0,6);

//        List<Car> data = Arrays.asList(car1,car2);

//        given(parService.findPar(anyInt())).willReturn(Optional.ofNullable(parameter1));
        given(carService.getCar(car1.getId())).willReturn(car1);

        assertThat(carService.getCar(car1.getId()));
//                   .hasSize(1)
//                    .contains(car1);


//        mockMvc.perform(getClass("/"))


    }





}
