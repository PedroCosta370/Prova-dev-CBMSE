package com.cbm.project.resources;

import com.cbm.project.domain.Person;
import com.cbm.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/people")
    public ResponseEntity<?> getPeople(){
        List<Person> people = personService.findAll();
        return ResponseEntity.ok(people);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id){
        Person person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping(value = "/people")
    public ResponseEntity postPerson(@RequestBody Person person){
        Person savedPerson = personService.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping(value = "/people/{id}")
    public ResponseEntity putPerson(@RequestBody Person person){
        Person updatedPerson = personService.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

}
