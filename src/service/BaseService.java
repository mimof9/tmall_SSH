package service;

import java.util.List;

import util.Page;

public interface BaseService {
	//总数
	public int total();
	//全部查询
	public List list();
	//分页查询
	public List listByPage(Page page);
	
	//添加
	public Integer save(Object obj);
	//删除
	public void delete(Object obj);
	//获取
	public Object get(Class clazz, int id);
	public Object get(int id);
	//更新
	public void update(Object obj);
	
	//根据父类对象，查询子类对象的集合
	public int total(Object parentObject); 
	public List listByParent(Object parent);
	public List list(Page page, Object parent);
	
	
	//多条件查询
	public List list(Object... pairParms);
		
}
