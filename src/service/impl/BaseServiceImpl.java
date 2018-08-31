package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import service.BaseService;
import util.Page;

@Service("base")
public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService{
	
	protected Class clazz;
	
	BaseServiceImpl(){
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement[] stes = e.getStackTrace();
			String sonFullName = stes[1].getClassName();
			try {
				Class sonClazz =  Class.forName(sonFullName);
				String sonSimpleName = sonClazz.getSimpleName();
				
				String beanSimpleName = sonSimpleName.replaceAll("ServiceImpl", "");
				String beanPackageName = sonClazz.getPackage().getName().replaceAll("service.impl", "bean");
				String beanFullName = beanPackageName + "." + beanSimpleName;
			
				clazz = Class.forName(beanFullName);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from " + clazz.getName();
		List<Long> l= find(hql);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
	}

	@Override
	public List listByPage(Page page) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc,page.getStart(),page.getCount());
	}

	@Override
	public Integer save(Object obj) {
		// TODO Auto-generated method stub
		return (Integer) super.save(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		super.delete(obj);
	}

	@Override
	public Object get(Class clazz, int id) {
		// TODO Auto-generated method stub
		return super.get(clazz, id);
	}
	
	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return get(clazz, id);
	}
	
	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		super.update(obj);
	}

	//���ݸ�����󣬲�ѯ�������ļ���
	@Override
	public int total(Object parentObject) {
		String parentName= parentObject.getClass().getSimpleName();
		//�ַ�������ĸСд
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
         
        String sqlFormat = "select count(*) from %s bean where bean.%s = ?";
        String hql = String.format(sqlFormat, clazz.getName(), parentNameWithFirstLetterLower);
         
        List<Long> l= this.find(hql,parentObject);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
	}

	@Override
	public List listByParent(Object parent) {
		String parentName= parent.getClass().getSimpleName();
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc);
	}

	@Override
	public List list(Page page, Object parent) {
		String parentName= parent.getClass().getSimpleName();
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc, page.getStart(), page.getCount());
	}

	/*
	 *��Ҫע����ǣ��������������ʱ��Ӧ���ṩż������������������
	 *1. ������ɱ������Ĳ���������key,value,key,value,key,value��Ԥ�У�ȡ���������Ž�Map��
	 *2. �������Map,����DetachedCriteria������ key,value�ķ�ʽ���ò�ѯ����
	 *	2.1 ��value��null��ʱ����Ҫʹ��dc.add(Restrictions.isNull(key)); �������Ĵ�����в�ѯ��
	 *3. ����id������
	 *4. ���ز�ѯ���
	 */
	@Override
	public List list(Object... pairParms) {
		HashMap<String,Object> m = new HashMap<>();
        for (int i = 0; i < pairParms.length; i=i+2)
            m.put(pairParms[i].toString(), pairParms[i+1]);
 
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
 
        Set<String> ks = m.keySet();
        for (String key : ks) {
            if(null==m.get(key))
                dc.add(Restrictions.isNull(key));
            else
                dc.add(Restrictions.eq(key, m.get(key)));
        }
        dc.addOrder(Order.desc("id"));
        return this.findByCriteria(dc);
	}

}
