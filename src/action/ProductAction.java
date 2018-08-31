package action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import bean.Product;
import util.Page;

public class ProductAction extends Action4Result{
	
	@Action("admin_product_list")
	public String list(){
		if(null == page)
			page = new Page(0,5);
		int total = productService.total(category);
		page.setTotal(total);
		
		products = productService.list(page, category);
		for (Product p : products) {			//设置缩略图
			productImageService.setFirstProdutImage(p);
		}
		
		page.setParam("&category.id="+category.getId());	//这样 就能保持分页的时候 category传回来
		
		t2p(category);
		return "listProduct";
	}
	
	@Action("admin_product_add")
	public String add(){
		product.setCreateDate(new Date());
		productService.save(product);
		return "listProductPage";
	}
	
	@Action("admin_product_delete")
	public String delete(){
		t2p(product);
		productService.delete(product);
		return "listProductPage";
	}
	
	@Action("admin_product_edit")
	public String edit(){
		t2p(product);
		return "editProduct";
	}
	
	@Action("admin_product_update")
	public String update(){
		Product productFromDB = (Product) productService.get(product.getId());
		product.setCreateDate(productFromDB.getCreateDate());
		productService.update(product);
		return "listProductPage";
	}
}
