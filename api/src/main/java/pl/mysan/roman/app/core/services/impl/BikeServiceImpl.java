package pl.mysan.roman.app.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.BikeDTO;
import pl.mysan.roman.app.core.models.entities.Bike;
import pl.mysan.roman.app.core.repositories.BikeRepository;
import pl.mysan.roman.app.core.services.BikeService;

@Service
@Transactional
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private VehicleAsm<Bike, BikeDTO> bikeAsm;

    @Override
    public BikeDTO save(BikeDTO bikeDTO) {
        bikeRepository.save(bikeAsm.convertToEntityObject(bikeDTO));
        return bikeDTO;
    }
}
