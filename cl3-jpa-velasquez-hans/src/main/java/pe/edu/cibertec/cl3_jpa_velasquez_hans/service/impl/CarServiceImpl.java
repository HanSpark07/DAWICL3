package pe.edu.cibertec.cl3_jpa_velasquez_hans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.entity.Car;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.repository.CarRepository;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDetailsDto;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.service.CarService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getOwnerContact()));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailsDto> getCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> new CarDetailsDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));
    }

    @Override
    public boolean updateCar(CarDto CarDto) throws Exception {
        Optional<Car> optional = carRepository.findById(CarDto.carId());
        return optional.map(car -> {
            car.setLicensePlate(CarDto.licensePlate());
            car.setOwnerName(CarDto.ownerName());
            car.setOwnerContact(CarDto.ownerContact());
            car.setServiceDueDate(new Date());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailsDto carDetailsDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailsDto.carId());
        if (optional.isPresent()) {
            return false;
        }else{
            Car car = new Car();
            car.setMake(carDetailsDto.make());
            car.setModel(carDetailsDto.model());
            car.setYear(carDetailsDto.year());
            car.setVin(carDetailsDto.vin());
            car.setLicensePlate(carDetailsDto.licensePlate());
            car.setOwnerName(carDetailsDto.ownerName());
            car.setOwnerContact(carDetailsDto.ownerContact());
            car.setPurchaseDate(new Date());
            car.setMileage(carDetailsDto.mileage());
            car.setEngineType(carDetailsDto.engineType());
            car.setColor(carDetailsDto.color());
            car.setInsuranceCompany(carDetailsDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailsDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(new Date());
            car.setServiceDueDate(new Date());
            carRepository.save(car);
            return true;
        }
    }
}
