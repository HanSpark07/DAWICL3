package pe.edu.cibertec.cl3_jpa_velasquez_hans.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDetailsDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.response.*;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {
    @Autowired
    CarService carService;

    @GetMapping("/all")
    public FindCarsResponse findCars(){
        try{
            List<CarDto> cars = carService.getAllCars();
            if(!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "Cars not found", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "An error occurred, please try again", null);
        }
    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "carId", defaultValue = "0") String carId){
        try {
            Optional<CarDetailsDto> optional = carService.getCarById(Integer.parseInt(carId));
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "Car not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error occurred, please try again", null);
        }
    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto){
        try {
            if (carService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Car not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error occurred, please try again");
        }

    }

    @DeleteMapping("/delete/{carId}")
    public DeleteCarResponse deleteCar(@PathVariable String carId){
        try{
            if(carService.deleteCarById(Integer.parseInt(carId)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "Car not found");
        } catch (Exception e){
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error occurred, please try again");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailsDto carDetailsDto){
        try {
            if(carService.addCar(carDetailsDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "Car already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");
        }
    }
}
