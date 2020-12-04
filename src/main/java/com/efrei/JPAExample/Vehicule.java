package com.efrei.JPAExample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Vehicule {
    private long idV;
    private String plateNumber;
    private Set<Rent> rents = new HashSet<Rent>();

    public Vehicule()  {
        super();
    }

    public Vehicule(String plaque)  {
        super();
        this.plateNumber=plaque;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdV() { return idV; }
    public void setIdV(long idV) { this.idV = idV; }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    @OneToMany(mappedBy="vehicule", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Rent> getRents() { return rents; }
    public void setRents(Set<Rent> rents) { this.rents = rents; }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idV=" + idV +
                ", plateNumber='" + plateNumber + '\'' +
                ", rents=" + rents +
                '}';
    }
}
