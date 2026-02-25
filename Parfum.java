package com.alaa.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Parfum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long idParfum;
    private String nomParfum;
    private  double prixParfum;
    private Date dateCreation;
    public Parfum() {
        super();
    }
    public Parfum(String nomParfum, double prixParfum, Date dateCreation) {
        super();
        this.nomParfum = nomParfum;
        this.prixParfum = prixParfum;
        this.dateCreation = dateCreation;
    }
    public void setIdParfum(long idParfum) {
        this.idParfum = idParfum;
    }
    public void setNomParfum(String nomParfum) {
        this.nomParfum = nomParfum;
    }
    public void setPrixParfum(double prixParfum) {
        this.prixParfum = prixParfum;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public long getIdParfum() {
        return idParfum;
    }
    public String getNomParfum() {
        return nomParfum;
    }
    public double getPrixParfum() {
        return prixParfum;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    @Override
    public String toString() {
        return "Parfum [idParfum=" + idParfum + ", nomParfum=" + nomParfum + ", prixParfum=" + prixParfum
                + ", dateCreation=" + dateCreation + "]";
    }

}
