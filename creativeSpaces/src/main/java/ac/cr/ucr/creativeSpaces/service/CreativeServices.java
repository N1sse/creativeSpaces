package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.Creative;
import ac.cr.ucr.creativeSpaces.repository.CreativeRegister;
import ac.cr.ucr.creativeSpaces.repository.IRegisterCreative;
import ac.cr.ucr.creativeSpaces.repository.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreativeServices implements IRegisterCreative {

    @Autowired
    CreativeRegister creativeRegister;

    //Mostrar todos los espacios
    @Override
    public List<Creative> getAllCreative() {
        return this.creativeRegister.getAllCreative();
    }

    //Agregar uno nuevo
    @Override
    public Creative addSpaces(Creative creative) {
        return this.creativeRegister.addSpaces(creative);
    }

    //Editar espacios
    @Override
    public Creative editSpaces(Integer idCreative, Creative spacesEdit) {
        return this.creativeRegister.editSpaces(idCreative, spacesEdit);
    }

    //Borrar espacios x ID
    @Override
    public Creative deleteSpaces(Integer idCreative) {
        return this.creativeRegister.deleteSpaces(idCreative);
    }

    //Buscar espacio por tipo o ubicacion
    public List<Creative> searchSpaces(String type, String location) {
        return this.creativeRegister.searchSpaces(type, location);
    }

    //Detalles
    @Override
    public Creative getSpaces(Integer idCreative) {
        return this.creativeRegister.getSpaces(idCreative);
    }

    public Boolean creativeExistsID (Integer idCreative){
        return this.creativeRegister.creativeExistsID(idCreative);
    }
}
