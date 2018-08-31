package service;

import java.util.List;

import util.Page;

public interface BaseService {
	//����
	public int total();
	//ȫ����ѯ
	public List list();
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
	
	//���ݸ�����󣬲�ѯ�������ļ���
	public int total(Object parentObject); 
	public List listByParent(Object parent);
	public List list(Page page, Object parent);
	
	
	//��������ѯ
	public List list(Object... pairParms);
		
}
