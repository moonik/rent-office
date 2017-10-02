package pl.mysan.roman.app.core.services.impl;

import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.dto.BorrowDTO;
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

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationAsm applicationAsm;

    @Override
    public VehicleDTO getVehicle(Long id) {
        return applicationAsm.convertToDto(applicationRepository.getVehicle(id));
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
    public BorrowDTO borrow(BorrowDTO borrowDTO) throws ParseException {
        Vehicle vehicle = applicationRepository.getVehicle(borrowDTO.getVehicle());
        Borrower borrower = applicationRepository.getBorrower(borrowDTO.getBorrower());
        Borrow borrow = applicationAsm.borrowDtoToBorrow(borrowDTO, borrower, vehicle);

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
}
