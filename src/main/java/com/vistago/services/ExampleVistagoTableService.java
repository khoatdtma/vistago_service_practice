package com.vistago.services;

import com.vistago.dtos.ExampleVistagoTableDto;
import com.vistago.entities.ExampleVistagoTable;
import com.vistago.repositories.ExampleVistagoTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExampleVistagoTableService {
    @Autowired
    private ExampleVistagoTableRepo exampleVistagoTableRepo;

    public ExampleVistagoTable save(ExampleVistagoTableDto exampleVistagoTable){
        ExampleVistagoTable existing = exampleVistagoTableRepo.findByExampleColumn(exampleVistagoTable.getExampleColumn());
        if(existing==null){
            ExampleVistagoTable newEntity = new ExampleVistagoTable();
            newEntity.setExampleColumn(exampleVistagoTable.getExampleColumn());
            return exampleVistagoTableRepo.save(newEntity);
        }else{
            throw new DataIntegrityViolationException("Entity with same exampleColumn already exist");
        }

    }

    public List<ExampleVistagoTable> findAll(){
        return exampleVistagoTableRepo.findAll();
    }

    public void delete(String exampleColumn){
        ExampleVistagoTable existing = exampleVistagoTableRepo.findByExampleColumn(exampleColumn);
        if(existing!=null){
            exampleVistagoTableRepo.delete(existing);
        }else{
            throw new EntityNotFoundException("Cannot find any entity with exampleColumn: " + exampleColumn);
        }
    }

}
