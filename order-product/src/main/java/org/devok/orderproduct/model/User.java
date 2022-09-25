package org.devok.orderproduct.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User {
    @Id
    private Long id;

}
