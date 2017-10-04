package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.*;

import java.text.ParseException;

@Component
public class ApplicationAsmImpl implements ApplicationAsm {
    @Override
    public VehicleDTO convertToDto(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());

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

    @Override
    public BorrowDTO borrowConvertToDto(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setBorrowDate(borrow.getBorrowDate());
        return borrowDTO;
    }

    @Override
    public Borrow borrowDtoToBorrow(BorrowDTO borrowDTO, Borrower borrower, Vehicle vehicle){
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setVehicle(vehicle);
        borrow.setBorrower(borrower);
        return borrow;
    }
}