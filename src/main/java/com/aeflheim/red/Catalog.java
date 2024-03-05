package com.aeflheim.red;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cid_seq")
    @SequenceGenerator(name = "cid_seq", sequenceName = "catalog_id_seq", initialValue = 4245342,
    allocationSize = 11)
    private Long id;

    private String name;

    public Catalog() {}

    public Catalog(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
