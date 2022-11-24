/*
 * 2. CategoryDAO

public void save(Category category);

public Category getById(int id);
// select * from categories where id=1;
	
public void update(Category category);
	
public void deleteById(int id);

public List<Category> getAll();

public Category getByName(String name);

// select * from Categories where name = ‘Beverages’;

public List<Category> getByNames(String substring);

//select * from Categories where name like ‘Con%’;

 */
//CategoryDAO Interface

package com.spring.core.jdbc.dao;

import java.util.List;

import com.spring.core.jdbc.model.Category;

public interface CategoryDAO {
	
	public void save(Category category);

	public Category getById(int id);
	
	public void update(Category category);
		
	public void deleteById(int id);

	public List<Category> getAll();

	public Category getByName(String name);

	public List<Category> getByNames(String substring);

}
