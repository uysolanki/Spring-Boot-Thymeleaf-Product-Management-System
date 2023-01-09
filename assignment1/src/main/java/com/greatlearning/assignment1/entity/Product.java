package com.greatlearning.assignment1.entity;




import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@jakarta.persistence.Entity
@Data
@NoArgsConstructor
public class Product {
	
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private int pno;
	
	@jakarta.persistence.Column(name="productname")
	private String pname;
	
	@jakarta.persistence.Column(name="quantity")
	private int qty;
	
	@jakarta.persistence.Column(name="unitprice")
	private double price;

	
	
	
	
}
