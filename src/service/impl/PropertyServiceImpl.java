package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import bean.Category;
import service.PropertyService;
import util.Page;

@Service
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {
//
//	@Override
//	public int Total(Category category) {
//		String sqlFormat = "select count(*) from %s bean where bean.category = ?";
//		String hql = String.format(sqlFormat, clazz.getName());
//		List<Long> l= find(hql,category);
//        if(l.isEmpty())
//            return 0;
//        Long result= l.get(0);
//        return result.intValue();
//	}
//
//	@Override
//	public List listByCategory(Category category) {
//		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
//        dc.add(Restrictions.eq("category", category));
//        dc.addOrder(Order.desc("id"));
//        return findByCriteria(dc);
//	}
//
//	@Override
//	public List list(Page page, Category category) {
//		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
//        dc.add(Restrictions.eq("category", category));
//        dc.addOrder(Order.desc("id"));
//        return findByCriteria(dc,page.getStart(),page.getCount());
//	}
	
}
