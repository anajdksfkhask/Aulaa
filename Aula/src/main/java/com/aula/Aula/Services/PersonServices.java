package com.aula.Aula.Services;

import com.aula.Aula.Data.Vo.v1.PersonVO;
import com.aula.Aula.Data.Vo.v2.PersonVOv2;
import com.aula.Aula.Exceptions.Handler.RequiredObjectIsNullException;
import com.aula.Aula.Exceptions.ResourceNotFoundException;
import com.aula.Aula.Mapper.Custom.PersonMapper;
import com.aula.Aula.Mapper.DozerMapper;
import com.aula.Aula.Model.Person;
import com.aula.Aula.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

    @Service
    public class PersonServices {


        private Logger logger = Logger.getLogger(PersonServices.class.getName());

        @Autowired
        PersonRepository repository;

        @Autowired
        PersonMapper mapper;

        public List<PersonVO> findAll() {

            logger.info("Finding all people!");

            return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
        }

        public PersonVO findById(Long id) {

            logger.info("Finding one person!");

            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            return DozerMapper.parseObject(entity, PersonVO.class);
        }

        public PersonVO create(PersonVO person) {
            if (person == null)throw new RequiredObjectIsNullException();
            logger.info("Creating one person!");
            var entity = DozerMapper.parseObject(person, Person.class);
            var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
            return vo;
        }

        public PersonVOv2 createV2(PersonVOv2 person) {

            logger.info("Creating one person with V2!");
            var entity = mapper.convertVoTOEntity(person);
            var vo = mapper.convertEntityToVo(repository.save(entity));
            return vo;
        }

        public PersonVO update(PersonVO person) {
            if (person == null)throw new RequiredObjectIsNullException();
            logger.info("Updating one person!");

            var entity = repository.findById(person.getKey())
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAdress(person.getAdress());
            entity.setGender(person.getGender());

            var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
            return vo;
        }

        public void delete(Long id) {

            logger.info("Deleting one person!");

            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            repository.delete(entity);
        }
    }
