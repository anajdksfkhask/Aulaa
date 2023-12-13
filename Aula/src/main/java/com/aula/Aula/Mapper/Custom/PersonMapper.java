package com.aula.Aula.Mapper.Custom;

import com.aula.Aula.Data.Vo.v2.PersonVOv2;
import com.aula.Aula.Model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOv2 convertEntityToVo(Person person) {
        PersonVOv2 vo = new PersonVOv2();
        vo.setId(person.getId());
        vo.setAdress(person.getAdress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }


    public Person convertVoTOEntity(PersonVOv2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAdress(person.getAdress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }
}
