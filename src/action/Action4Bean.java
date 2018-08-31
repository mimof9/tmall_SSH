package action;

import java.util.List;

import bean.Category;

public class Action4Bean extends Action4Pagination{
	//分页
	protected List<Category> thecs;
	//添加 删除 获取 编辑
	protected Category category;
	
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
}
