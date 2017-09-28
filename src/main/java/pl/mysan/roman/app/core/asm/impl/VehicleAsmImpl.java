package pl.mysan.roman.app.core.asm.impl;

import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Bike;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Car;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class VehicleAsmImpl implements VehicleAsm {
    @Override
    public VehicleDTO convertToDto(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();

        if(vehicle instanceof Car){
            vehicleDTO.setColor(((Car) vehicle).getColor());
            vehicleDTO.setName(((Car) vehicle).getName());
            vehicleDTO.setProducent(((Car) vehicle).getProducent());
            vehicleDTO.setReleaseDate(((Car) vehicle).getReleaseDate().toString());
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
        borrowDTO.setBorrowDate(borrow.getBorrowDate().toString());
        borrowDTO.setBorrower(borrow.getBorrower());
        borrowDTO.setVehicle(borrow.getVehicle());
        return borrowDTO;
    }

    @Override
    public Borrow borrowDtoToBorrow(BorrowDTO borrowDTO) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
        Date date = format.parse(borrowDTO.getBorrowDate());
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(date);
        borrow.setBorrower(borrowDTO.getBorrower());
        return borrow;
    }


}
