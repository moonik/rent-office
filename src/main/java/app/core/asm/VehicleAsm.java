package app.core.asm;

import app.core.dto.VehicleDTO;
import app.core.models.entities.Vehicle;

public interface VehicleAsm {

    Vehicle convertToVehicle(VehicleDTO vehicleDTO);
}
