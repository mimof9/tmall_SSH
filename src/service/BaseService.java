package service;

import java.util.List;

import util.Page;

public interface BaseService {
	//全部查询
	public List list();
	//总数
	public int total();
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
}
