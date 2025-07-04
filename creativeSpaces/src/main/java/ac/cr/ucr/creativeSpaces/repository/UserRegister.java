package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Sirve para hacer una clase en repositorio
public class UserRegister implements IRegisterUser {

    private ArrayList<User> listUser;

    public UserRegister(){
        this.listUser = new ArrayList<>();
    }

    //@override = Sirve para sobrescribir el metodo de una clase padre o una interfaz
    @Override
    public User addUser(User user) {
       this.listUser.add(user);
        return user;
    }//fin saveUser

    @Override
    public List<User> getAllUser() {
        return this.listUser;
    }

    @Override
    public User getUser(Integer id) {
       for (int i=0; i<this.listUser.size(); i++){
           if (this.listUser.get(i).getId()==id){
               return this.listUser.get(i);
           }
       }
        return new User();
    }

    @Override
    public User deleteUser(Integer id) {
        for (int i=0; i<this.listUser.size(); i++){
            if (this.listUser.get(i).getId()==id){
                User u=this.listUser.get(i);
                this.listUser.remove(i);
                return u;
            }
        }
        return new User();
    }

    @Override
    public User editUser(Integer id, User userEdit) {
        for (int i=0; i<this.listUser.size(); i++){
            if (this.listUser.get(i).getId()==id){
                this.listUser.set(i, userEdit);
                return this.listUser.get(i);
            }
        }
        return new User();
    }

    public Boolean existID(Integer id){
        //Este metodo no tiene el override, ya que la clase padre UserRegister no tiene ese metodo

        //-----
        //Este metodo permite comprobar si hay un id igual
        for (int i=0; i<this.listUser.size(); i++){
            if (this.listUser.get(i).getId()==id){
                return  true;
            }
        }
        return false;
    }
}
