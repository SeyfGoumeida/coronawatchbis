package com.efrei.JPAExample;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {
 private Date beginRent;
 private Date endRent;
 private long idR;
 private Vehicule vehicule;
 private Person person;

    public Rent(){super();}
    public Rent(Date debut , Date fin){
        super();
        this.beginRent = debut;
        this.endRent = fin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdR() { return idR; }
    public void setIdR(long idR) { this.idR = idR; }

    @ManyToOne(cascade=CascadeType.ALL)
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    @ManyToOne(cascade=CascadeType.ALL)
    public Vehicule getVehicule() { return vehicule; }
    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule; }

    @Temporal(TemporalType.DATE)
    public Date getBeginRent() { return beginRent; }
    public void setBeginRent(Date beginRent) { this.beginRent = beginRent; }
    @Temporal(TemporalType.DATE)
    public Date getEndRent() { return endRent; }
    public void setEndRent(Date endRent) { this.endRent = endRent; }

    @Override
    public String toString() {
        return "Rent{" +
                "beginRent=" + beginRent +
                ", endRent=" + endRent +
                ", idR=" + idR +
                ", vehicule=" + vehicule +
                ", person=" + person +
                '}';
    }
}
