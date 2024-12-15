package pe.edu.cibertec.cl3_jpa_velasquez_hans.response;

import pe.edu.cibertec.cl3_jpa_velasquez_hans.dto.CarDetailsDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailsDto car) {
}
