package ac.cr.ucr.creativeSpaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Entidad que representa un espacio creativo en la base de datos
@Table(name = "tb_creative") //Para poder crear la tabla y ponerle el nombre tb_creative
public class Creative {

    @Id //  Es para marcar una clave primaria mediante el jpa
    private Integer idCreative;
    private String spacesName;
    private String location;
    private String typePlaces;
    private Boolean available;
    private String rentalDate;
    private Integer price;
    private String owner;

    public Creative() {
        this.idCreative = 0;
        this.price = 0;
    } //fin const sin parámetros

    public Creative(String rentalDate, String equipment, Integer hours, Integer idCreative, String name, String location, String type, Boolean available, Integer price, String owner) {
        this.idCreative = idCreative;
        this.spacesName = name;
        this.location = location;
        this.typePlaces = type;
        this.available = available;
        this.price = price;
        this.owner = owner;
        this.rentalDate = rentalDate;
    } //fin const con parámetros


    //------------Set & Gets-----------
    public Integer getIdCreative() {
        return idCreative;
    }

    public void setIdCreative(Integer idCreative) {
        this.idCreative = idCreative;
    }

    public String getSpacesName() {
        return spacesName;
    }

    public void setSpacesName(String spacesName) {
        this.spacesName = spacesName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypePlaces() {
        return typePlaces;
    }

    public void setTypePlaces(String typePlaces) {
        this.typePlaces = typePlaces;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }


}// fin Creative
