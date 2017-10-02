package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.BikeAsm;
import pl.mysan.roman.app.core.dto.BikeDTO;
import pl.mysan.roman.app.core.models.entities.Bike;

@Component
public class BikeAsmImpl implements BikeAsm {
    @Override
    public Bike convertToBike(BikeDTO bikeDTO) {
        Bike bike = new Bike();
        bike.setNumber(bikeDTO.getNumber());
        return bike;
    }

    @Override
    public BikeDTO convertToDto(Bike bike) {
        BikeDTO bikeDTO = new BikeDTO();
        bikeDTO.setNumber(bike.getNumber());
        return bikeDTO;
    }
}
