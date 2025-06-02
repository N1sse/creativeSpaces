package ac.cr.ucr.creativeSpaces.controller;

import ac.cr.ucr.creativeSpaces.model.Creative;
import ac.cr.ucr.creativeSpaces.service.CreativeServices;
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
@RequestMapping("/api/creative")
public class CreativeController {

    @Autowired
    CreativeServices creativeServices;
/*
--API debe permitir:
● Listar todos los espacios creativos
● Agregar un nuevo espacio creativo.
● Actualizar los datos de un espacio creativo.
● Eliminar un espacio creativo
● Buscar un espacio creativo por tipo o ubicación
● Ver detalles de un espacio creativo por su id
● Postman para pruebas de endpoints
 */

    // Muestra la lista de todos los espacios creativos
    @GetMapping
    public List<Creative> getAllCreative() {
        return this.creativeServices.findAllCreative();  // Retorna/Busca todos los espacios creativos
    }

    // Mostrar datos de un espacio creativo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCreativeById(@PathVariable Integer id) {
        Optional<Creative> creative = this.creativeServices.findByIDCreative(id);
        if (creative==null || creative.get().getIdCreative() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio creativo con el ID " + id + " no fue encontrado.");
        }
        return ResponseEntity.ok(creative);
    }

    // Agregar un nuevo espacio creativo
    @PostMapping
    public ResponseEntity<?> addCreative(@Validated @RequestBody Creative creative, @org.jetbrains.annotations.NotNull BindingResult result) {
        if (result.hasErrors()) {
            // Esta parte es para validar errores
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Creative newCreative = this.creativeServices.saveCreative(creative); //guarda los datos del espacio
        return ResponseEntity.status(HttpStatus.CREATED).body(newCreative);
    }

    // Editar los datos de un espacio creativo, gracias a su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCreative(@PathVariable Integer id, @RequestBody Creative creativeEdit) {
        Optional<Creative> creative = this.creativeServices.findByIDCreative(id);
        if (creative==null || creative.get().getIdCreative() == 0) {
            // Esta parte es para validar errores y mostrar un mensaje que no se encontró el ID
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el espacio creativo con el ID " + id);
        }

        creativeEdit.setIdCreative(id); // Asegurar que el ID coincida
        Creative updatedCreative = this.creativeServices.saveCreative(creativeEdit);//guarda los nuevos datos del espacio
        return ResponseEntity.ok(updatedCreative);
    }

    // Eliminar un espacio creativo por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCreative(@PathVariable Integer id) {
        Optional<Creative> creative = this.creativeServices.findByIDCreative(id);
        if (creative.isEmpty() || creative.get().getIdCreative() == 0) {
            // Esta parte es para validar errores y mostrar un mensaje que no se encontró el ID
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ID " + id + " no ha podido ser encontrado.");
        }
        this.creativeServices.deleteCreative(id); //elimina el espacio
        return ResponseEntity.ok("El espacio creativo con el ID " + id + " fue eliminado exitosamente.");
    }

    // Buscar por tipo
    @GetMapping("/search/type")
    public ResponseEntity<?> findByType(@RequestParam String type) {
        List<Creative> creative = this.creativeServices.findByType(type);
        if (creative.isEmpty()) {
            //Esta parte es para validar si no hay datos así
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron espacios creativos de tipo " + type);
        }
        return ResponseEntity.ok(creative);
    }

    // Buscar por ubicación
    @GetMapping("/search/location")
    public ResponseEntity<?> findByLocation(@RequestParam String location) {
        List<Creative> creative = this.creativeServices.findByLocation(location);
        if (creative.isEmpty()) {
            //Esta parte es para validar si no hay datos así
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron espacios creativos que se ubiquen en " + location);
        }
        return ResponseEntity.ok(creative);
    }

   /*
   -----------Codigo original (parte que no se cambio)
   @GetMapping("/{id}")
    public Creative getSpaces(@PathVariable Integer id){
        return this.creativeServices.getSpaces(id);
    }

    @DeleteMapping("/{id}")
    public Creative deleteSpaces(@PathVariable Integer id){
        return this.creativeServices.deleteSpaces(id);
    }

    @PutMapping("/{id}")
    public Creative editSpaces(@PathVariable Integer id, @RequestBody Creative  spacesEdit) {
        return this.creativeServices.editSpaces(id,  spacesEdit);
    }
    */
} //fin del creative controller
