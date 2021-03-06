package action;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import service.BaseService;
import service.CategoryService;
import service.OrderItemService;
import service.OrderService;
import service.ProductImageService;
import service.ProductService;
import service.PropertyService;
import service.PropertyValueService;
import service.ReviewService;
import service.UserService;

public class Action4Service extends Action4Bean{
	@Resource(name="base")
	BaseService baseService;			
//	除了@Autowired 还可以
//	1. BaseServiceImpl的注解要写成：@Service("base")
//	2. Action4Service里新加一个 
//	@Resource(name="base")
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	PropertyService propertyService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	PropertyValueService propertyValueService;
	@Autowired
	UserService userService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ReviewService reviewService;
	
	/**
	 * transient to persistent
	 * 瞬时对象转换为持久对象
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
