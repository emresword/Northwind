package coding.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> {
	List<Product> getByProductNameContains(String productName);
	Product getByProductName(String productName);
	List<Product> getByProductNameOrCategoryId(String productName,int categoryId);
	List<Product> getByProductNameStartsWith(String productName);
	List<Product> getByCategoryIdIn(List<Integer> categoryIds);
//	@Query("From Product where productName=:productName and categoryId=categoryId")
//	List<Product> getByNameAndCategoryId(@Param("productName")String producName,@Param("categoryId")int categoryId);
//	
    @Query("From Product where productName = :productName and category.id = :categoryId")
    List<Product> getByNameAndCategoryId(@Param("productName") String productName, @Param("categoryId") int categoryId);
	@Query("Select new coding.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select  p.productId,p.prodctName,c.categoryName from Category c inner join Product p on 
	// c.categoryıd=p.productıd
}
