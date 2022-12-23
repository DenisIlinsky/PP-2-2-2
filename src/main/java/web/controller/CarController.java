package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarService;
import web.Service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model,
                            @RequestParam(value = "count", required = false)
                                    Integer count) {
        model.addAttribute("cars", carService.returnCars(count));
        return "carTable";
    }
}
