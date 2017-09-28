package pl.mysan.roman.app.core.services.impl;

import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Vehicle;
import pl.mysan.roman.app.core.repositories.VehicleRepository;
import pl.mysan.roman.app.core.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleAsm vehicleAsm;

    @Override
    public VehicleDTO getVehicle(Long id) {
        return vehicleAsm.convertToDto(vehicleRepository.getVehicle(id));
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<VehicleDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getAll()) {
            vehicles.add(vehicleAsm.convertToDto(vehicle));
        }
        return vehicles;
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.delete(id);
    }

    @Override
    public BorrowDTO borrow(BorrowDTO borrowDTO) throws ParseException {
        Borrow borrow = vehicleAsm.borrowDtoToBorrow(borrowDTO);
        vehicleRepository.borrow(borrow);
        return borrowDTO;
    }
}
