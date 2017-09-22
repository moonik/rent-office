package app.core.asm.impl;

import app.core.asm.VehicleAsm;
import app.core.dto.VehicleDTO;
import app.core.models.entities.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleAsmImpl implements VehicleAsm{
    @Override
    public Vehicle convertToVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDTO.getType());
        return vehicle;
    }
}
