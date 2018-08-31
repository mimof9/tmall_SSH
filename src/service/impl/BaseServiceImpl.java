package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
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

}
