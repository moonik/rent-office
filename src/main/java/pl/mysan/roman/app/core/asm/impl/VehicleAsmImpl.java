package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Bike;
import pl.mysan.roman.app.core.models.entities.Car;
import pl.mysan.roman.app.core.models.entities.Vehicle;

@Component
public class VehicleAsmImpl implements VehicleAsm {
    @Override
    public VehicleDTO convertToDto(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();

        if(vehicle instanceof Car){
            vehicleDTO.setColor(((Car) vehicle).getColor());
            vehicleDTO.setName(((Car) vehicle).getName());
            vehicleDTO.setProducent(((Car) vehicle).getProducent());
            vehicleDTO.setReleaseDate(((Car) vehicle).getReleaseDate());
            vehicleDTO.setType("Car");
        }else if(vehicle instanceof Bike){
            vehicleDTO.setNumber(((Bike) vehicle).getNumber());
            vehicleDTO.setType("Bike");
        }

        return vehicleDTO;
    }
}
