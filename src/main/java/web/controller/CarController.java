package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Car;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model cars) {
        List<Car> carList = Car.getNewCarList();
        cars.addAttribute("carList", carList.subList(0, (count >=5) ? 5 : count));
        return "cars";
    }
}
