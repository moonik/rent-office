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
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationAsm applicationAsm;

    @Override
    public VehicleDTO getVehicle(Long id, String date) throws ParseException {
        Vehicle vehicle = applicationRepository.getVehicle(id);
        Borrow borrow = applicationRepository.getBorrowInfo(date, vehicle);
        VehicleDTO vehicleDTO = applicationAsm.vehicleConvertToDto(vehicle);
        if(borrow != null) {
            vehicleDTO.setBorrowDate(borrow.getBorrowDate());
        }
        return vehicleDTO;
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<VehicleDTO> vehicles = new ArrayList<>();
        applicationRepository.getAll().forEach(vehicle -> vehicles.add(applicationAsm.vehicleConvertToDto(vehicle)));
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
        Borrow borrow = applicationAsm.borrowDtoConvertToBorrow(borrowDTO, borrower, vehicle);

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
    public List<VehicleDTO> getAllWithBorrowDate(String date){
        List<VehicleDTO> vehicles = new ArrayList<>();
        applicationRepository.getAll().forEach(vehicle -> {
            VehicleDTO vehicleDTO = applicationAsm.vehicleConvertToDto(vehicle);
            Borrow borrow = null;
            try {
                borrow = applicationRepository.getBorrowInfo(date, vehicle);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(borrow != null) {
                vehicleDTO.setBorrowDate(borrow.getBorrowDate());
                vehicleDTO.setBorrower(borrow.getBorrower().getName());
            }
            vehicles.add(vehicleDTO);
        });
        return vehicles;
    }

    @Override
    public List<BorrowerDTO> getUsers() {
        List<BorrowerDTO> users = new ArrayList<>();
        applicationRepository.getUsers().forEach(borrower -> users.add(applicationAsm.borrowerConvertToBorrowerDto(borrower)));
        return users;
    }

    @Override
    public void unborrow(Long id, String date) throws ParseException {
        Vehicle vehicle = applicationRepository.getVehicle(id);
        applicationRepository.unborrow(vehicle, date);
    }

    @Override
    public VehicleDTO getVehicle(Long id) {
        return applicationAsm.vehicleConvertToDto(applicationRepository.getVehicle(id));
    }
}