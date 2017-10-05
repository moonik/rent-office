package pl.mysan.roman.app.core.services.impl;

import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.models.entities.Vehicle;
import pl.mysan.roman.app.core.repositories.ApplicationRepository;
import pl.mysan.roman.app.core.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationAsm applicationAsm;

    @Override
    public VehicleDTO getVehicle(Long id) {
        Vehicle vehicle = applicationRepository.getVehicle(id);
        return  applicationAsm.convertToDto(vehicle);
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<VehicleDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle : applicationRepository.getAll()) {
            vehicles.add(applicationAsm.convertToDto(vehicle));
        }
        return vehicles;
    }

    @Override
    public void delete(Long id) {
        applicationRepository.delete(id);
    }

    @Override
    public BorrowDTO borrow(BorrowDTO borrowDTO){
        Vehicle vehicle = applicationRepository.getVehicle(borrowDTO.getVehicle());
        vehicle.setWasBorrowed(true);
        Borrower borrower = applicationRepository.getBorrower(borrowDTO.getBorrower());
        Borrow borrow = applicationAsm.borrowDtoToBorrow(borrowDTO, borrower, vehicle);

        applicationRepository.save(vehicle);
        applicationRepository.borrow(borrow);
        return borrowDTO;
    }

    @Override
    public Borrower save(String name) {
        Borrower borrower = new Borrower();
        borrower.setName(name);
        applicationRepository.save(borrower);
        return borrower;
    }

    @Override
    public List<VehicleDTO> getAllWithBorrowDate(String date) throws ParseException {
        List<VehicleDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle : applicationRepository.getAll()){
            VehicleDTO vehicleDTO = applicationAsm.convertToDto(vehicle);
            Borrow borrow = applicationRepository.getBorrowInfo(date, vehicle);
            if(borrow != null) {
                vehicleDTO.setBorrowDate(borrow.getBorrowDate());
                vehicleDTO.setBorrower(borrow.getBorrower().getName());
            }
            vehicles.add(vehicleDTO);
        }
        return vehicles;
    }

    @Override
    public List<BorrowerDTO> getUsers() {
        List<BorrowerDTO> users = new ArrayList<>();
        for (Borrower borrower : applicationRepository.getUsers()){
            users.add(applicationAsm.convertToDto(borrower));
        }
        return users;
    }
}