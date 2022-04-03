package com.wescale;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class GreetingEntity extends PanacheEntity {

   public String message;

}
