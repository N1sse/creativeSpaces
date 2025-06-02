package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.repository.UserRegister;
import ac.cr.ucr.creativeSpaces.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository  userRepository;


    public User saveUser(User user) {
        return this.userRepository.save(user);
    }


    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

    public Optional<User> findByIDUser(Integer id){
        return this.userRepository.findById(id);
    }

    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }




   /*

    @Autowired
    UserRegister userRegister;

    public User saveUser(User user) {
        return this.userRegister.addUser(user);
    }


    public List<User> getAllUser() {
        return this.userRegister.getAllUser();
    }


    public User getUser(Integer id) {
        return this.userRegister.getUser(id);
    }


    public User deleteUser(Integer id) {
        return this.userRegister.deleteUser(id);
    }


    public User editUser(Integer id, User userEdit) {
        return this.userRegister.editUser(id, userEdit);
    }

    public Boolean existID (Integer id){
        return this.userRegister.existID(id);
    }

    */
}
