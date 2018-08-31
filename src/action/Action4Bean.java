package action;

import java.util.List;

import bean.Category;
import bean.Property;

public class Action4Bean extends Action4Pagination{
	//分页
	protected List<Category> thecs;
	//添加 删除 获取 编辑
	protected Category category;
	
	protected List<Property> ps;
	protected Property property;
	
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
	public List<Property> getPs() {
		return ps;
	}
	public void setPs(List<Property> ps) {
		this.ps = ps;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
}
