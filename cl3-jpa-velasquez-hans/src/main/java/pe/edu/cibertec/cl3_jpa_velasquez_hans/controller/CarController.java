package pe.edu.cibertec.cl3_jpa_velasquez_hans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<CarDto> cars = carService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", null);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los carros");
        }
        return "car";
    }
}
