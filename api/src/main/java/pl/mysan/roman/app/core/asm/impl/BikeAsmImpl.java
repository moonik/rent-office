package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.BikeDTO;
import pl.mysan.roman.app.core.models.entities.Bike;

@Component
public class BikeAsmImpl implements VehicleAsm<Bike, BikeDTO> {

    @Override
    public Bike convertToEntityObject(BikeDTO dto) {
        Bike bike = new Bike();
        bike.setNumber(dto.getNumber());
        return bike;
    }

    @Override
    public BikeDTO convertToDtoObject(Bike entityObject) {
        BikeDTO bikeDTO = new BikeDTO();
        bikeDTO.setNumber(entityObject.getNumber());
        return bikeDTO;
    }
}
