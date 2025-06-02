package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.Creative;
import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.repository.CreativeRegister;
import ac.cr.ucr.creativeSpaces.repository.CreativeRepository;
import ac.cr.ucr.creativeSpaces.repository.IRegisterCreative;
import ac.cr.ucr.creativeSpaces.repository.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreativeServices{

    @Autowired
    private CreativeRepository creativeRepository;

    // Guardar o actualizar espacio
    public Creative saveCreative(Creative creative) {
        return this.creativeRepository.save(creative);
    }

    // Listar todos los espacios
    public List<Creative> findAllCreative() {
        return this.creativeRepository.findAll();
    }

    // Buscar por ID
    public Optional<Creative> findByIDCreative(Integer id) {
        return this.creativeRepository.findById(id);
    }

    // Eliminar por ID
    public void deleteCreative(Integer id) {
        this.creativeRepository.deleteById(id);
    }

    // Buscar por tipo
    public List<Creative> findByType(String type) {
        return creativeRepository.findAll().stream()
                .filter(c -> c.getTypePlaces() != null && c.getTypePlaces().toLowerCase().contains(type.toLowerCase()))
                .toList();
    }

    // Buscar por ubicación
    public List<Creative> findByLocation(String location) {
        return creativeRepository.findAll().stream()
                .filter(c -> c.getLocation() != null && c.getLocation().toLowerCase().contains(location.toLowerCase()))
                .toList();
    }



    /*
    // Código original con repositorio en memoria (CreativeRegister)

    @Autowired
    CreativeRegister creativeRegister;

    public List<Creative> getAllCreative() {
        return this.creativeRegister.getAllCreative();
    }

    public Creative addSpaces(Creative creative) {
        return this.creativeRegister.addSpaces(creative);
    }

    public Creative editSpaces(Integer idCreative, Creative spacesEdit) {
        return this.creativeRegister.editSpaces(idCreative, spacesEdit);
    }

    public Creative deleteSpaces(Integer idCreative) {
        return this.creativeRegister.deleteSpaces(idCreative);
    }

    public List<Creative> searchSpaces(String type, String location) {
        return this.creativeRegister.searchSpaces(type, location);
    }

    public Creative getSpaces(Integer idCreative) {
        return this.creativeRegister.getSpaces(idCreative);
    }

    public Boolean creativeExistsID(Integer idCreative){
        return this.creativeRegister.creativeExistsID(idCreative);
    }
    */
}