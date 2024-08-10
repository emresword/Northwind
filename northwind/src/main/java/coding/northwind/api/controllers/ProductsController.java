package coding.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.northwind.business.abstracts.ProductService;
import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

}
