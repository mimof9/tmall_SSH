package action;

import java.util.List;

import bean.Category;

public class Action4Bean extends Action4Pagination{
	//��ҳ
	protected List<Category> thecs;
	//��� ɾ�� ��ȡ �༭
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
