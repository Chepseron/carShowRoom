/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anonymous
 */
@Entity
@Table(name = "showroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showroom.findAll", query = "SELECT s FROM Showroom s"),
    @NamedQuery(name = "Showroom.findByIdshowroom", query = "SELECT s FROM Showroom s WHERE s.idshowroom = :idshowroom"),
    @NamedQuery(name = "Showroom.findByCarMake", query = "SELECT s FROM Showroom s WHERE s.carMake = :carMake"),
    @NamedQuery(name = "Showroom.findByColor", query = "SELECT s FROM Showroom s WHERE s.color = :color"),
    @NamedQuery(name = "Showroom.findByRegistrationNumber", query = "SELECT s FROM Showroom s WHERE s.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "Showroom.findByYearOfManufacturing", query = "SELECT s FROM Showroom s WHERE s.yearOfManufacturing = :yearOfManufacturing"),
    @NamedQuery(name = "Showroom.findByType", query = "SELECT s FROM Showroom s WHERE s.type = :type"),
    @NamedQuery(name = "Showroom.findByAvailability", query = "SELECT s FROM Showroom s WHERE s.availability = :availability"),
    @NamedQuery(name = "Showroom.findByDateCreated", query = "SELECT s FROM Showroom s WHERE s.dateCreated = :dateCreated"),
    @NamedQuery(name = "Showroom.findByDateUpdated", query = "SELECT s FROM Showroom s WHERE s.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "Showroom.findByDeleted", query = "SELECT s FROM Showroom s WHERE s.deleted = :deleted")})
public class Showroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idshowroom")
    private Integer idshowroom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carMake")
    private String carMake;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "registrationNumber")
    private String registrationNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearOfManufacturing")
    private int yearOfManufacturing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "availability")
    private String availability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private int deleted;

    public Showroom() {
    }

    public Showroom(Integer idshowroom) {
        this.idshowroom = idshowroom;
    }

    public Showroom(Integer idshowroom, String carMake, String color, String registrationNumber, int yearOfManufacturing, String type, String availability, Date dateCreated, Date dateUpdated, int deleted) {
        this.idshowroom = idshowroom;
        this.carMake = carMake;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.yearOfManufacturing = yearOfManufacturing;
        this.type = type;
        this.availability = availability;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.deleted = deleted;
    }

    public Integer getIdshowroom() {
        return idshowroom;
    }

    public void setIdshowroom(Integer idshowroom) {
        this.idshowroom = idshowroom;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(int yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idshowroom != null ? idshowroom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showroom)) {
            return false;
        }
        Showroom other = (Showroom) object;
        if ((this.idshowroom == null && other.idshowroom != null) || (this.idshowroom != null && !this.idshowroom.equals(other.idshowroom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Showroom[ idshowroom=" + idshowroom + " ]";
    }
    
}
