package pe.edu.cibertec.cl3_jpa_velasquez_hans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.cl3_jpa_velasquez_hans.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
