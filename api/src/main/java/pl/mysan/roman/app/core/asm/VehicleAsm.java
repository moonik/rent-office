package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.models.entities.Vehicle;

public interface VehicleAsm <T extends Vehicle, D> {
    T convertToEntityObject(D dto);
    D convertToDtoObject(T entityObject);
}
