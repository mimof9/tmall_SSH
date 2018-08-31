package service;

import java.util.List;

import util.Page;

public interface BaseService {
	//ȫ����ѯ
	public List list();
	//����
	public int total();
	//��ҳ��ѯ
	public List listByPage(Page page);
	//���
	public Integer save(Object obj);
	//ɾ��
	public void delete(Object obj);
	//��ȡ
	public Object get(Class clazz, int id);
	public Object get(int id);
	//����
	public void update(Object obj);
}
