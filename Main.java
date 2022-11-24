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

2.	Create a spring core application to achieve the following requirements

CategoryDAO

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


===========================================================================

ProductDAO

public void save(Product product);

public Product getById(int id);
	
public void update(Product product);
	
public void deleteById(int id);

public List< Product > getAll();

public Product getByName(String name);

public List< Product > getByNames(String substring);


public List<Product> getByBetweenPrice(double iPrice, double oPrice);
// select * from products where price between 300 and 1200;

public List<Product> getDiscontinuedProducts();

3.	You can create a spring.xml to do these activities.

 */
//Main Class of All the class

package com.spring.core.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.jdbc.dao.CategoryDAO;
import com.spring.core.jdbc.dao.ProductDAO;
import com.spring.core.jdbc.model.Category;
import com.spring.core.jdbc.model.Product;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			 context =new ClassPathXmlApplicationContext("spring.xml");
			 
			 //Category class
			 System.out.println("Category Class .... ..");
			 System.out.println();
			 
			 CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
				
			 Category c1 = new Category();
				
			 int rand = new Random().nextInt(1000);
				
			 c1.setId(rand);
			 c1.setName("Perfume");
			 c1.setDescription("Fragrance of Rose like perfume");
				
			//Save values to the table	
			 categoryDAO.save(c1);
				
			 System.out.println("Category is saved successfully");
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			 
			 //Update values in the table
			 c1.setName("Body Lotion");
			 categoryDAO.update(c1);
				
			 List<Category> cList = categoryDAO.getAll();
			 System.out.println(cList);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Delete the value by Id
			 categoryDAO.deleteById(rand);
			 
			 //Display all the records
			 cList = categoryDAO.getAll();
			 System.out.println(cList);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Display all the records of categories table having name Perfume
			 Category cat2 = categoryDAO.getByName("Perfume");
			 System.out.println("Category by name :" + cat2);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			//Display all the records of categories table having substring Perfume
			 List<Category> cList2 = categoryDAO.getByNames("P");
			 System.out.println(cList2);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Product class
			 System.out.println("Product Class .... ..");
			 System.out.println();
				
			 ProductDAO productDAO = context.getBean(ProductDAO.class);
				
			 Product p1 = new Product();
				
			 int randp = new Random().nextInt(1000);
				
			 p1.setId(randp);
			 p1.setName("Denver body Spray");
			 p1.setPrice(500.00);
			 p1.setUnitsInStock(10);
			 p1.setDiscontinued(true);
			
			 //Save the records in table Product
			 productDAO.save(p1);
				
			 System.out.println("Product is saved successfully");
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Display the records by id
			 Product pro = productDAO.getById(randp);
			 System.out.println("Product by id :" + pro);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Update the records of table by provided id
			 p1.setName("Ponds Body wash");
			 p1.setDiscontinued(false);
			 p1.setPrice(200);
			 p1.setUnitsInStock(5);
			 productDAO.update(p1);
			
			 //Display all the records of table products
			 List<Product> pList = productDAO.getAll();
			 System.out.println(pList);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Delete the records of table Product by id
			 productDAO.deleteById(rand);
				
			 pList = productDAO.getAll();
			 System.out.println(pList);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Display the records of table by name
			 Product pro2 = productDAO.getByName("Ponds body wash");
			 System.out.println("Product by name :" + pro2);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
				
			 //Display the records of table by substring
			 List<Product> pList2 = productDAO.getByNames("P");
			 System.out.println(pList2);
				
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Display all the records having price in between
			 List<Product> pro3 = productDAO.getByBetweenPrice(20, 500);
			 System.out.println(pro3);
			
			 System.out.println();
			 System.out.println("**************************************************");
			 System.out.println();
			
			 //Display records of discontinued products
			 List<Product> pro4 = productDAO.getDiscontinuedProducts();
			 System.out.println(pro4);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(context != null)
				context.close();
		}

	}

}
