package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Vehicle;

public interface VehicleAsm {
    VehicleDTO convertToDto(Vehicle vehicle);
}
