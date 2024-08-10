package coding.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.northwind.business.abstracts.ProductService;
import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.core.utilities.results.SuccessDataResult;
import coding.northwind.core.utilities.results.SuccessResult;
import coding.northwind.dataAccess.abstracts.ProductDao;
import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;
import net.bytebuddy.asm.Advice.This;
@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
	    List<Product> products = productDao.findAll();
	    return new SuccessDataResult<>(products, "Data are listed");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product is added");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data are listed");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data are listed");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategoryId(productName,categoryId),"Data are listed");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith( productName),"Data are listed");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String producName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategoryId( producName, categoryId),"Data are listed");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categoryIds) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIdIn(categoryIds),"Data are listed");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data are listed");
	}
}
