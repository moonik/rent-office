package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO getVehicle(Long id);
    List<VehicleDTO> getAll();
}
