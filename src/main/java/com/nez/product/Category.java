package com.nez.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.nez.model.NamedEntity;

@Entity
@Table(name = "categories")
public class Category extends NamedEntity{

}
