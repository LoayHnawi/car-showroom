package cars.controller;

import cars.home.*;
import cars.home.Parameter;
import cars.service.CarService;
import cars.service.SellService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/car")
public class controller {

    @Autowired
    private CarService carService;

    @Autowired
    private SellService sellService;

    private static final Logger logger = Logger.getLogger(Controller.class.getName());
    private Car car11;

    @GetMapping(value = {"/",""})
    public String viewHomePage(Model model) {
        model.addAttribute("car", carService.findCars());
        logger.log(Level.INFO,"View All Unsold Cars");
        return "index";
    }

    @GetMapping("/viewDrop")
    public String viewDrop(Model model) {
        model.addAttribute("sell", sellService.findCarsSell());
        logger.log(Level.INFO,"View All Sold Cars");
        return "dropDownList";
    }

    @RequestMapping("/idSell/{id}")
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 100,rollbackFor = Exception.class)
    public String idSell(Model model ,@PathVariable(name = "id") Integer id) {

         Car car = carService.getCar(id);
         Sell sellC = new Sell();
         car11 = car;
         carService.deleteCar(car.getId());
         model.addAttribute("sellC",sellC);
         return "CarSell";
    }

    @PostMapping("/saveD")
    public String saveD(@ModelAttribute("sell") Sell sell) {
        sell.setId(car11.getId());
        sell.setName(car11.getName());
        sell.setNum_disk(car11.getNum_disk());
        sell.setPrice(car11.getPrice());
        sell.setParameters(car11.getParameters());
        Parameter parameter2 = new Parameter("RateMoney", 10);
        if (sell.getSell_price() == 0) {
            sell.setSell_price((car11.getPrice()) + car11.getPrice() *parameter2.getValue() /100);
        }
        sell.getParameters().add(parameter2);
        sellService.saveSell(sell);
        logger.log(Level.INFO,"Save : "+sell.getName()+" Car in The Sold Cars List");
        return "redirect:/api/car";
    }

    @GetMapping("/newCar")
    public String newCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "newCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        if (car.getNum_disk() == 0) {
            car.setNum_disk(4);
        }
        Parameter parameter1 = new Parameter("num_disk", car.getNum_disk());
        car.getParameters().add(parameter1);
        carService.saveCar(car);
        logger.log(Level.INFO,"Save : "+car.getName()+" Car in The Unsold Cars List");
        return "redirect:/api/car";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") Integer id) {

            carService.deleteCar(id);
            return "redirect:/api/car";
        }

    @RequestMapping("/del/{id}")
    public String deleteCarSell(@PathVariable(name = "id") Integer id) {

        sellService.deleteCarSell(id);
        return "redirect:/api/car/viewDrop";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model ,@PathVariable(name = "id") Integer id) {
        Car car = carService.getCar(id);
        Car updateC = new Car();
        carService.deleteCar(car.getId());
        model.addAttribute("updateC",updateC);
        return "Update";
    }

    @RequestMapping("/saveU")
    public String saveUpdate(@ModelAttribute("car") Car car) {

        carService.saveCar(car);
        logger.log(Level.INFO,"Save : "+car.getName()+" Car in The Sold Cars List");
        return "redirect:/api/car";
    }

}
