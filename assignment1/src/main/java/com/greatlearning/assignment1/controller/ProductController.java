package com.greatlearning.assignment1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.greatlearning.assignment1.response.MyResponse;
import com.greatlearning.assignment1.controller.service.ProductService;
import com.greatlearning.assignment1.entity.Product;

@Controller
@RequestMapping(value="/flipkart") //optional
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping(value="/addproduct")
	public MyResponse addProduct(@RequestParam("pno") int pno,
			@RequestParam("pname") String pname,
			@RequestParam("qty") int qty,
			@RequestParam("price") double price)
			{
		MyResponse response=new MyResponse();
		
		Product product=new Product();
		product.setPno(pno);
		product.setPname(pname);
		product.setQty(qty);
		product.setPrice(price);
		try
		{
		service.addProduct(product);
		response.setMessage("Record Inserted Successfully");
		response.setStatus(true);
		response.setStatuscode(HttpStatus.OK);
		}
		catch(Exception e) {}
	
		return response;
	}
	
	@PostMapping(value="/addproductbody")
	public MyResponse addProductBody(@RequestBody Product product)
	{
		MyResponse response=new MyResponse();
		try
		{
		service.addProduct(product);
		response.setMessage("Record Inserted Successfully");
		response.setStatus(true);
		response.setStatuscode(HttpStatus.OK);
		}
		catch(Exception e) {}
		return response;
	}

	@GetMapping(value="/getallproducts")
	public String getAllproducts(Model model)
	{
		model.addAttribute("great", service.getAllProducts());
		return("great");
	}
	
	
}
