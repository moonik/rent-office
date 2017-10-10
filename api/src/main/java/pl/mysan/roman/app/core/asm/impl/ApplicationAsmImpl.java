package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.*;

import java.text.ParseException;

@Component
public class ApplicationAsmImpl implements ApplicationAsm {
    @Override
    public VehicleDTO vehicleConvertToDto(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());

        if(vehicle instanceof Car){
            vehicleDTO.setColor(((Car) vehicle).getColor());
            vehicleDTO.setName(((Car) vehicle).getName());
            vehicleDTO.setProducent(((Car) vehicle).getProducent());
            vehicleDTO.setReleaseDate(((Car) vehicle).getReleaseDate());
            vehicleDTO.setType("Car");
            vehicleDTO.setWasBorrowed(vehicle.getWasBorrowed());
        }else if(vehicle instanceof Bike){
            vehicleDTO.setNumber(((Bike) vehicle).getNumber());
            vehicleDTO.setType("Bike");
            vehicleDTO.setWasBorrowed(vehicle.getWasBorrowed());
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
    public Borrow borrowDtoConvertToBorrow(BorrowDTO borrowDTO, Borrower borrower, Vehicle vehicle){
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setVehicle(vehicle);
        borrow.setBorrower(borrower);
        return borrow;
    }

    @Override
    public BorrowerDTO borrowerConvertToBorrowerDto(Borrower borrower) {
        BorrowerDTO borrowerDTO = new BorrowerDTO();
        borrowerDTO.setName(borrower.getName());
        borrowerDTO.setId(borrower.getId());
        return borrowerDTO;
    }

    @Override
    public Borrower convertToBorrower(BorrowerDTO borrowerDTO) {
        Borrower borrower = new Borrower();
        borrower.setName(borrowerDTO.getName());
        return borrower;
    }
}