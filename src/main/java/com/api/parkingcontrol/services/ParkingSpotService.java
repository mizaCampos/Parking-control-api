package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ParkingSpotService {


    final ParkingSpotRepository  parkingSpotrepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotrepository) {
        this.parkingSpotrepository = parkingSpotrepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotrepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotrepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotrepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotrepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable){
        return parkingSpotrepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotrepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotrepository.delete(parkingSpotModel);
    }
}
