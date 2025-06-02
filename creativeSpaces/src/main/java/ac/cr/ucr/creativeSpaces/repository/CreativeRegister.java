package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.Creative;
import ac.cr.ucr.creativeSpaces.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Sirve para hacer una clase en repositorio
public class CreativeRegister implements IRegisterCreative{

    private ArrayList<Creative> listCreative;

    public CreativeRegister(){
        this.listCreative = new ArrayList<>();
    }

    /*
        Listar todos los espacios creativos
        Agregar un nuevo espacio creativo.
        Actualizar los datos de un espacio creativo.
        Eliminar un espacio creativo
        Buscar un espacio creativo por tipo o ubicación
        Ver detalles de un espacio creativo por su id
     */


    //Enlistar todos los espacios creativos
    @Override
    public List<Creative> getAllCreative() {
        return this.listCreative;
    }

    //Agregar nuevos espacios creativos
    @Override
    public Creative addSpaces(Creative creative) {
        this.listCreative.add(creative);
        return creative;
    }//end addSpaces


    //Editar espacios Creativos
    @Override
    public Creative editSpaces(Integer idCreative, Creative spacesEdit) {
        for (int i = 0; i < this.listCreative.size(); i++) {
            if (this.listCreative.get(i).getIdCreative() == idCreative) {
                this.listCreative.set(i, spacesEdit);
                return this.listCreative.get(i);
            }
        }
        return new Creative();
    }

    //Borrar los espacios creativos
    @Override
    public Creative deleteSpaces(Integer idCreative) {
        for (int i=0; i<this.listCreative.size(); i++){
            if (this.listCreative.get(i).getIdCreative()==idCreative){
                Creative cSp=this.listCreative.get(i);
                this.listCreative.remove(i);
                return cSp;
            }
        }
        return new Creative();
    }

    //Buscar espacio creativo x tipo o ubicación
    public List<Creative> searchSpaces(String type, String location) {
        List<Creative> filteredSpaces = new ArrayList<>();
        for (Creative space : listCreative) {
            if ((type == null || space.getTypePlaces().equalsIgnoreCase(type)) &&
                    (location == null || space.getLocation().equalsIgnoreCase(location))) {
                filteredSpaces.add(space);
            }
        }
        return filteredSpaces;
    }

    //Detalles de espacios creativos
    @Override
    public Creative getSpaces(Integer idCreative) {
        for (int i=0; i<this.listCreative.size(); i++){
            if (this.listCreative.get(i).getIdCreative()==idCreative){
                return this.listCreative.get(i);
            }
        }
        return new Creative();
    }

    public Boolean creativeExistsID (Integer idCreative){
        for (int i=0; i<this.listCreative.size(); i++){
            if (this.listCreative.get(i).getIdCreative()==idCreative){
                return  true;
            }
        }
        return false;
    }
}
