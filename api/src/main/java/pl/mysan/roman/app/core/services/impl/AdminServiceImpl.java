package pl.mysan.roman.app.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mysan.roman.app.core.asm.ApplicationAsm;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.exception.NotFoundException;
import pl.mysan.roman.app.core.models.entities.UserAccount;
import pl.mysan.roman.app.core.models.entities.Vehicle;
import pl.mysan.roman.app.core.repositories.ApplicationRepository;
import pl.mysan.roman.app.core.repositories.UserRepository;
import pl.mysan.roman.app.core.services.AdminService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationAsm applicationAsm;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.getUsers().forEach(user ->
            users.add(applicationAsm.userConvertToUserDTO(user))
        );
        return users;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteVehicle(Long id) {
        if(applicationRepository.ifExists(id)) {
            applicationRepository.delete(id);
        }else
            throw new NotFoundException(id);
    }

    @Override
    public void unborrow(Long id, String date) throws ParseException {
        Vehicle vehicle = applicationRepository.getVehicle(id);
        if(vehicle == null){
            throw new NotFoundException(id);
        }else
            applicationRepository.unborrow(vehicle, date);
    }
}
