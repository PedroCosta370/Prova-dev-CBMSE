package com.cbm.project.services;

import com.cbm.project.domain.Person;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    private final Person personToInsert = new Person(1, "Maria Júlia", "Souza Cardoso");
    private final Person personToUpdate = new Person(2, "Maria Marmelina", "Souza Balieiro");
    private final Person expectedUpdatedPerson = new Person(2, "Maria Marmelina Updatada", "Souza Balieiro Updatada");


    @Test
    @Order(1)
    public void save(){
        Person result = personService.save(personToInsert);
        assertEquals(personToInsert, result);
    }

    @Test
    @Order(2)
    public void findById(){
        Person person = personService.findById(personToInsert.getId());
        assertEquals(personToInsert, person);
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Person> peopleList = personService.findAll();
        assertTrue(peopleList.size()>0);
    }

    @Test
    @Order(4)
    public void update(){
        Person savedPerson = personService.save(personToUpdate);
        expectedUpdatedPerson.setId(savedPerson.getId());

        Person updated = personService.save(expectedUpdatedPerson);
        assertEquals(expectedUpdatedPerson, updated);;
    }

    @Test
    @Order(5)
    public void delete(){
        boolean deleted = personService.delete(expectedUpdatedPerson.getId());
        assertEquals(true, deleted);
    }
}
