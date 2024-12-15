package pe.edu.cibertec.cl3_jpa_velasquez_hans.service;

import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDetailsDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailsDto> getCarById(int carId) throws Exception;

    boolean updateCar(CarDto userDto) throws Exception;

    boolean deleteCarById(int carId) throws Exception;

    boolean addCar(CarDetailsDto carDetailsDto) throws Exception;
}
