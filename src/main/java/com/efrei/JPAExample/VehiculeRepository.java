package com.efrei.JPAExample;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

    Set<Vehicule> findByplateNumber(String plateNumber);

}