package com.efrei.JPAExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

    VehiculeRepository vehiculeRepository;

    @Autowired
    public RestWebService(VehiculeRepository vehiculeRepository) {
        super();
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/vehicules")
    public Iterable<Vehicule> getVehicules(){
        return vehiculeRepository.findAll();
    }

    @PostMapping("/vehicules")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addVehicule(@RequestBody Vehicule vehicule) throws Exception {
        vehiculeRepository.save(vehicule);
        if(vehicule.getPlateNumber().equals("AA11BB")){
            throw new Exception();
        }
    }


}
