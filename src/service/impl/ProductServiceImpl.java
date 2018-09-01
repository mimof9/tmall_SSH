package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Category;
import bean.Product;
import service.ProductImageService;
import service.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Autowired
    ProductImageService productImageService;	
	
	@Override
	public void fill(List<Category> categorys) {
		for (Category category : categorys)
			fill(category);
	}

	@Override
	public void fill(Category category) {
		List<Product> products = listByParent(category);
		
		for (Product product : products) {
			productImageService.setFirstProdutImage(product);
		}
		
		category.setProducts(products);
	}

	@Override
	public void fillByRow(List<Category> categorys) {
		int productNumberEachRow = 8;
		for (Category category : categorys) {
			List<Product> products = category.getProducts();
			List<List<Product>> productsByRow = new ArrayList<>();
			for(int i=0;i<products.size();i+=productNumberEachRow){
				int end = i+productNumberEachRow;
				end = end>products.size()?products.size():end;
				List<Product> productsOfEachRow = products.subList(i, end);
				productsByRow.add(productsOfEachRow);
			}
			category.setProductsByRow(productsByRow);
		}
		
	}

}
