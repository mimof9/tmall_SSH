package action;

import java.util.List;

import bean.Category;
import bean.Order;
import bean.Product;
import bean.ProductImage;
import bean.Property;
import bean.PropertyValue;
import bean.Review;
import bean.User;

public class Action4Bean extends Action4Pagination{
	//分类 ：用于分页 添加 删除 获取 编辑
	protected List<Category> thecs;
	protected Category category;
	//属性
	protected List<Property> propertys;
	protected Property property;
	//产品
	protected List<Product> products;
	protected Product product;
	//产品图片
	protected ProductImage productImage;
	protected List<ProductImage> productSingleImages;
	protected List<ProductImage> productDetailImages;
	//属性值
	protected PropertyValue propertyValue;
	protected List<PropertyValue> propertyValues;
	//用户
	protected List<User> users;
	protected User user;
	//订单
	protected Order order;
	protected List<Order> orders;
	//评价
	protected Review review;
	protected List<Review> reviews;
	
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
