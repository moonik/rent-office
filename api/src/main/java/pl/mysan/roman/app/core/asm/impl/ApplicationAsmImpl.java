package pl.mysan.roman.app.core.asm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class ApplicationAsmImpl implements ApplicationAsm {

    @Override
    public VehicleDTO vehicleConvertToDto(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());

        if (vehicle instanceof Car) {
            vehicleDTO.setColor(((Car) vehicle).getColor());
            vehicleDTO.setName(((Car) vehicle).getName());
            vehicleDTO.setProducent(((Car) vehicle).getProducent());
            vehicleDTO.setReleaseDate(((Car) vehicle).getReleaseDate());
            vehicleDTO.setType("Car");
            vehicleDTO.setWasBorrowed(vehicle.getWasBorrowed());
        }else if (vehicle instanceof Bike) {
            vehicleDTO.setNumber(((Bike) vehicle).getNumber());
            vehicleDTO.setType("Bike");
            vehicleDTO.setWasBorrowed(vehicle.getWasBorrowed());
        }

        return vehicleDTO;
    }

    @Override
    public BorrowDTO borrowConvertToBorrowDto(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setBorrowDate(borrow.getBorrowDate());
        return borrowDTO;
    }

    @Override
    public Borrow borrowDtoConvertToBorrow(BorrowDTO borrowDTO, UserAccount borrower, Vehicle vehicle){
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setVehicle(vehicle);
        borrow.setBorrower(borrower);
        return borrow;
    }

    @Override
    public UserDTO userConvertToUserDTO(UserAccount userAccount) {
        return new UserDTO(userAccount.getUsername(), userAccount.getId(),
                userAccount.getAuthorities().stream()
                        .map(a -> a.getName().toString())
                        .collect(Collectors.joining()));
    }

    @Override
    public UserAccount userDTOConvertToUserAccount(UserDTO userDTO) {
        return new UserAccount(userDTO.getUsername(), new BCryptPasswordEncoder().encode(userDTO.getPassword()), true, new Date());
    }
}