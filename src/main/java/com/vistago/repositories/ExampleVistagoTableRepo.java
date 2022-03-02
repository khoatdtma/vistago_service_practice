package com.vistago.repositories;

import com.vistago.entities.ExampleVistagoTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleVistagoTableRepo extends JpaRepository<ExampleVistagoTable, Long> {

    ExampleVistagoTable findByExampleColumn(String exampleColumn);
}
