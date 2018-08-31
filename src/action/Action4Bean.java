package action;

import java.util.List;

import bean.Category;
import bean.Product;
import bean.ProductImage;
import bean.Property;
import bean.PropertyValue;

public class Action4Bean extends Action4Pagination{
	//分页
	protected List<Category> thecs;
	//添加 删除 获取 编辑
	protected Category category;
	
	protected List<Property> propertys;
	protected Property property;
	
	protected List<Product> products;
	protected Product product;
	
	protected ProductImage productImage;
	protected List<ProductImage> productSingleImages;
	protected List<ProductImage> productDetailImages;
	
	protected PropertyValue propertyValue;
	protected List<PropertyValue> propertyValues;	
	
	public List<Category> getThecs() {
		return thecs;
	}
	public void setThecs(List<Category> thecs) {
		this.thecs = thecs;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Property> getPropertys() {
		return propertys;
	}
	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}
	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}
	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}
	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}
	public PropertyValue getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(PropertyValue propertyValue) {
		this.propertyValue = propertyValue;
	}
	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}
	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}
	
}
