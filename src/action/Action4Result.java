package action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	@Result(name="listCategory",location="/admin/listCategory.jsp"),
	@Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
	@Result(name="editCategory", location="/admin/editCategory.jsp"),
	
	@Result(name="listProperty", location="/admin/listProperty.jsp"),
	@Result(name="listPropertyPage", type = "redirect", location="/admin_property_list?category.id=${property.category.id}"),
	@Result(name="editProperty", location="/admin/editProperty.jsp"),
	
	@Result(name="listProduct", location="/admin/listProduct.jsp"),
	@Result(name="listProductPage", type = "redirect", location="/admin_product_list?category.id=${product.category.id}"),
	@Result(name="editProduct", location="/admin/editProduct.jsp"),
	
	@Result(name="listProductImage", location="/admin/listProductImage.jsp"),
	@Result(name="listProductImagePage", type="redirect", location="/admin_productImage_list?product.id=${productImage.product.id}"),
	
	@Result(name="editPropertyValue", location="/admin/editPropertyValue.jsp"),
	@Result(name="editPropertyValuePage", type="redirect", location="/admin_propertyValue_edit?product.id=${propertyValue.product.id}"),
	})
public class Action4Result extends Action4Service{
	
}
