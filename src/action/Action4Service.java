package action;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import service.BaseService;
import service.CategoryService;

public class Action4Service extends Action4Bean{
	@Resource(name="base")
	BaseService baseService;			
//	����@Autowired ������
//	1. BaseServiceImpl��ע��Ҫд�ɣ�@Service("base")
//	2. Action4Service���¼�һ�� 
//	@Resource(name="base")
	
	@Autowired
	CategoryService categoryService;
	
	/**
	 * transient to persistent
	 * ˲ʱ����ת��Ϊ�־ö���
	 * @param o
	 */
	public void t2p(Object o){
		try {
			Class clazz = o.getClass();
			int id = (Integer) clazz.getMethod("getId").invoke(o);
			Object persistentBean = baseService.get(clazz, id);
			String beanName = clazz.getSimpleName();
			Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
			setMethod.invoke(this, persistentBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
