package service;

import java.util.List;

import bean.Category;

public interface ProductService extends BaseService {
	
	public void fill(List<Category> categorys);
	public void fill(Category category);
	public void fillByRow(List<Category> categorys);
	
}
