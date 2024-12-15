package pe.edu.cibertec.cl3_jpa_velasquez_hans.response;

import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
