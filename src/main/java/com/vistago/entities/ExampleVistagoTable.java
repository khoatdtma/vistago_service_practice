package com.vistago.entities;


import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "EXAMPLE_VISTAGO_TABLE")
public class ExampleVistagoTable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EXAMPLE_COLUMN", unique = true)
    private String exampleColumn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExampleColumn() {
        return exampleColumn;
    }

    public void setExampleColumn(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }
}
