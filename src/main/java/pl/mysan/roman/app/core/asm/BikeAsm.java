package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.BikeDTO;
import pl.mysan.roman.app.core.models.entities.Bike;

public interface BikeAsm {
    Bike convertToBike(BikeDTO bikeDTO);
    BikeDTO convertToDto(Bike bike);
}
