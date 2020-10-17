package com.cbm.project.services;

import com.cbm.project.domain.Person;
import com.cbm.project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Integer id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }


    public boolean delete(Integer id){
        try {
            personRepository.deleteById(id);;
            return true;
        }catch (Exception exception){
            return false;
        }
    }


}
