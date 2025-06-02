package ac.cr.ucr.creativeSpaces.controller;

import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.findAllUser(); //Retorna / busca todos los usuarios
    }


    //Obtener usuario
    @GetMapping("/{id}")
    public ResponseEntity<?> getUSer(@PathVariable Integer id){
      Optional<User> user= this.userService.findByIDUser(id);
      if (user==null || user.get().getId()==0){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con ese id: " + id + ", no se ha encontrado" );
          //el body es el cuerpo valga la redondancia
      }
        return ResponseEntity.ok(user);
    }

    // Agregar usuarios
    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
       if (result.hasErrors()){
           //Estos son llave valor, s eparece al json
           Map<String, String> errors = new HashMap<>();
           for (FieldError error : result.getFieldErrors()){
               errors.put(error.getField(), error.getDefaultMessage());
           } //getFieldErrors es para guardar una referencia de todos los errores
           return  ResponseEntity.badRequest().body(errors);
           //entonces asi se retornaría los valores
       }
       //verificar si existe el id
       /*if (this.userService.existID(user.getId())){

           return  ResponseEntity.status(HttpStatus.CONFLICT).body("EL usuario con el ID " + user.getId() + ", ya se encuentra registrado" );
       } */

       //referencia del user
        User userAdd = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAdd);
    }

    //Borrar usuarios por su id
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
      /* if (this.userService.existID(id)){
           this.userService.deleteUser(id);
           return ResponseEntity.status(HttpStatus.OK).body("El usuario con el ID "+ id+ " fue eliminado exitosamente.");
       }*/
        this.userService.deleteUser(id);
       return  ResponseEntity.status(HttpStatus.CONFLICT).body("El ID " + id +" no ha podido ser encontrado. Revise que este registrado");
    }

    /*

    //----------------------------------------------

     //Codigo Original
    //------------

    @PostMapping

    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

     @GetMapping("/{id}")
    public User getUSer(@PathVariable Integer id){
        return this.userService.getUser(id);
    }

       @DeleteMapping ("/{id}")
    public User deleteUser(@PathVariable Integer id){
        return this.userService.deleteUser(id);
     }


    @PutMapping("/{id}")
    public User editUser(@PathVariable Integer id, @RequestBody User useEdit){
        return this.userService.editUser(id, useEdit);

   //Editar los usuarios e identificarles por su id
   //Esta parte el unico al tener sus comentarios originales, ya que no se edito en la clase

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@Validated @PathVariable Integer id, @RequestBody User userEdit, BindingResult result){
        if (result.hasErrors()){
            //Estos son llave valor, se parece al json
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            } //getFieldErrors es para guardar una referencia de todos los errores
            return  ResponseEntity.badRequest().body(errors);
            //entonces asi se retornaría los valores
        }

        if (this.userService.existID(id)) {
            if (id != userEdit.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El Id de la busqueda no es el mismo del objeto editado");
            } else {
                return ResponseEntity.ok(this.userService.editUser(id, userEdit));
            }
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el Id "+id+" no se ha podido editar");
    }

   //----------------------------------------------

    //Ejemplos vistos en clase
    //ejem ejercicio suma
    @GetMapping("/{a}/{b}")
    public String suma(@PathVariable Integer a, @PathVariable Integer b){
       Integer suma=a+b;
        if (suma>18){
            return "Es mayor de edad";
        }
        return "Es menor de edad";
    }

   //Ejemplo de mensaje
    @GetMapping("/mensaje/{name}")
    public String mensaje(@PathVariable String name){
        return "Little snowman " + name;
    }
    */

}//fin del user controller

