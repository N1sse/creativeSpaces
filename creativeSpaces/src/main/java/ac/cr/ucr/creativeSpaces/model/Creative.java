package ac.cr.ucr.creativeSpaces.model;

public class Creative {
    private Integer idCreative;
    private String spacesName;
    private String location;
    private String typePlaces;
    private Boolean available;
    private String rentalDate;
    private String equipment;
    private Integer hours;
    private Integer price;
    private String owner;

    public Creative() {
        this.idCreative = 0;
        this.hours = 0;
        this.price = 0;
    }

    public Creative(String rentalDate, String equipment, Integer hours, Integer idCreative, String name, String location, String type, Boolean available, Integer price, String owner) {
        this.idCreative = idCreative;
        this.spacesName = name;
        this.location = location;
        this.typePlaces = type;
        this.available = available;
        this.price = price;
        this.owner = owner;
        this.rentalDate = rentalDate;
        this.equipment = equipment;
        this.hours = hours;
    }

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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
