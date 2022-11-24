/*
 * 1.	Write a program by using JdbcTemplate for the following requirements

1.	Create table categories and products with the following structures.

categories
	id int(11) unsigned not null, and the same column is the primary key
	name nvarchar(50) not null
	description nvarchar(100)

products
	id int(11) unsigned not null, and the same column is the primary key
	name nvarchar(50) not null
	price double not null
	unitsInStock int (at present how many units are there?)
	discontinued(whether the product is still doing business or not)


 */

//Category class

package com.spring.core.jdbc.model;

public class Category {
	private int id;
	private String name;
	private String description;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
