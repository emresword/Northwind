package coding.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<Product> getByProductName(String productName);
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	DataResult<List<Product>> getByNameAndCategoryId(@Param("productName")String producName,@Param("categoryId")int categoryId);
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categoryIds);
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
