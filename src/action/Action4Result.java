package action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	//分类管理
	@Result(name="listCategory",location="/admin/listCategory.jsp"),
	@Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
	@Result(name="editCategory", location="/admin/editCategory.jsp"),
	//属性管理
	@Result(name="listProperty", location="/admin/listProperty.jsp"),
	@Result(name="listPropertyPage", type = "redirect", location="/admin_property_list?category.id=${property.category.id}"),
	@Result(name="editProperty", location="/admin/editProperty.jsp"),
	//产品管理
	@Result(name="listProduct", location="/admin/listProduct.jsp"),
	@Result(name="listProductPage", type = "redirect", location="/admin_product_list?category.id=${product.category.id}"),
	@Result(name="editProduct", location="/admin/editProduct.jsp"),
	//产品图片管理
	@Result(name="listProductImage", location="/admin/listProductImage.jsp"),
	@Result(name="listProductImagePage", type="redirect", location="/admin_productImage_list?product.id=${productImage.product.id}"),
	//属性值管理
	@Result(name="editPropertyValue", location="/admin/editPropertyValue.jsp"),
	@Result(name="editPropertyValuePage", type="redirect", location="/admin_propertyValue_edit?product.id=${propertyValue.product.id}"),
	//用户管理
	@Result(name="listUser", location="/admin/listUser.jsp"),
	//订单管理
	@Result(name="listOrder", location="/admin/listOrder.jsp"),
	@Result(name="listOrderPage", type="redirect", location="/admin_order_list"),
	
	//首页
	@Result(name="home", location="/fore/homePage.jsp"),
	@Result(name="homePage", type="redirect", location="/forehome"),
	//注册
	@Result(name="registerPage", location="/fore/registerPage.jsp"),
	@Result(name="registerSuccessPage", type="redirect", location="/fore/registerSuccessPage.jsp"),
	//登陆
	@Result(name="loginPage", location="/fore/loginPage.jsp"),
	//产品
	@Result(name="product", location="/fore/productPage.jsp"),
	
	//返回成功 失败
	@Result(name="success", location="/success.jsp"),
	@Result(name="fail", location="/fail.jsp"),
	
	//分类
	@Result(name="category", location="/fore/categoryPage.jsp"),
	//搜索
	@Result(name="searchResult", location="/fore/searchResultPage.jsp"),
	
	})
public class Action4Result extends Action4Parameter{
	
}
