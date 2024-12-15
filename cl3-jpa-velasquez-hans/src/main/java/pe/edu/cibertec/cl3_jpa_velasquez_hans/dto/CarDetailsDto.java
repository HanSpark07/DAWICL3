package pe.edu.cibertec.cl3_jpa_velasquez_hans.dto;

import java.util.Date;

public record CarDetailsDto(Integer carId,
         String make,
         String model,
         Integer year,
         String vin,
         String licensePlate,
         String ownerName,
         String ownerContact,
         Date purchaseDate,
         Integer mileage,
         String engineType,
         String color,
         String insuranceCompany,
         String insurancePolicyNumber,
         Date registrationExpirationDate,
         Date serviceDueDate) {
}
