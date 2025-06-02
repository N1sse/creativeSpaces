package ac.cr.ucr.creativeSpaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Entidad que representa un usuario en la base de datos
@Table(name = "tb_user")  //Para poder crear la tabla y ponerle el nombre tb_user
public class User {
    @Id //  Es para marcar una clave primaria mediante el jpa
    private Integer id;
    private String name;
    private String telephone;
    private String email;

    public User(){
        this.id=0;
    } //fin const sin parametros

    public User(Integer id, String name, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    } //fin const con parametros

    //------------Set & Gets-----------
    //---
    //set & get id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //set & get name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //set & get telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //set & get email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
