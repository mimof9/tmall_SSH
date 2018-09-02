package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.math.RandomUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionContext;

import bean.Order;
import bean.OrderItem;
import bean.Product;
import bean.User;
import comparator.ProductAllComparator;
import comparator.ProductDateComparator;
import comparator.ProductPriceComparator;
import comparator.ProductReviewComparator;
import comparator.ProductSaleCountComparator;
import service.OrderService;

public class ForeAction extends Action4Result {
	@Action("forehome")
	public String home(){
		thecs = categoryService.list();
		productService.fill(thecs);
		productService.fillByRow(thecs);
		
		return "home";
	}
	
	@Action("foreregister")
	public String register(){
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		boolean exist = userService.isExist(user.getName());
		if(exist){
			msg = "�û����Ѿ���ʹ�ã�����ʹ��";
			user = null;		//�������user�ÿ� ��ô�������������жϵ�½�˸��Ѿ���ע���user ��Ȼֻ����һ��ҳ�������� �������ǲ���
			return "registerPage";
		}
		userService.save(user);
		return "registerSuccessPage";
	}
	
	@Action("forelogin")
	public String login(){
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		User user_session = userService.get(user.getName(),user.getPassword());
		if(null == user_session){
			msg= "�˺��������";
	        return "loginPage";
		}
		ActionContext.getContext().getSession().put("user", user_session);
		return "homePage";
	}
	
	@Action("forelogout")
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "homePage";
	}
	
	@Action("foreproduct")
	public String product(){
		t2p(product);
		
		productImageService.setFirstProdutImage(product);
		productSingleImages = productImageService.list("product",product,"type",productImageService.type_single);
		productDetailImages = productImageService.list("product",product,"type",productImageService.type_detail);
		product.setProductSingleImages(productSingleImages);
		product.setProductDetailImages(productDetailImages);
		
		productService.setSaleAndReviewNumber(product);

		propertyValues = propertyValueService.listByParent(product);	//��������ֵ ǰֻ̨�ܲ鿴
		reviews = reviewService.listByParent(product);
		
		return "product";
	}
	
	@Action("forecheckLogin")
	public String checkLogin(){
		User u =(User) ActionContext.getContext().getSession().get("user");
	    if(null == u)
	    	return "fail";
	    else
	        return "success";
	}
	
	@Action("foreloginAjax")
	public String loginAjax(){
		user.setName(HtmlUtils.htmlEscape(user.getName()));
	    User user_session = userService.get(user.getName(),user.getPassword());
	    
	    if(null == user_session)
	        return "fail";
	    
	    ActionContext.getContext().getSession().put("user", user_session);
	    return "success";
	}
	
	@Action("forecategory")
	public String category(){
	    t2p(category);
	    productService.fill(category);
	    productService.setSaleAndReviewNumber(category.getProducts());      
	      
	    if(null != sort){
	    switch(sort){
	        case "review":
	            Collections.sort(category.getProducts(),new ProductReviewComparator());
	            break;
	        case "date" :
	            Collections.sort(category.getProducts(),new ProductDateComparator());
	            break;
	        case "saleCount" :
	            Collections.sort(category.getProducts(),new ProductSaleCountComparator());
	            break;
	        case "price":
	            Collections.sort(category.getProducts(),new ProductPriceComparator());
	            break;
	        case "all":
	            Collections.sort(category.getProducts(),new ProductAllComparator());
	            break;
	        }
	    }
	    return "category";         
	}
	
	@Action("foresearch")
	public String search(){
	    products= productService.search(keyword,0,20);
	    productService.setSaleAndReviewNumber(products);
	    for (Product product : products)
	        productImageService.setFirstProdutImage(product);  
	     
	    return "searchResult";
	}
	
	//�������� ֱ�ӵ�����ҳ
	@Action("forebuyone")
	public String buyone(){
		User user =(User) ActionContext.getContext().getSession().get("user");
		boolean found = false;
	    List<OrderItem> ois = orderItemService.list("user",user,"order", null);
	    for (OrderItem oi : ois) {
	        if(oi.getProduct().getId()==product.getId()){
	            oi.setNumber(oi.getNumber()+num);
	            orderItemService.update(oi);
	            found = true;
	            oiid = oi.getId();
	            break;
	        }
	    }
	    
	    if(!found){
	        OrderItem oi = new OrderItem();
	        oi.setUser(user);
	        oi.setNumber(num);
	        oi.setProduct(product);
	        orderItemService.save(oi);
	        oiid = oi.getId();
	    }
		
		return "settleAccountPage";
	}
	
	//����
	@Action("foresettle")
	public String settle(){
		orderItems = new ArrayList<>();
	    for (int oiid : oiids) {
	        OrderItem oi= (OrderItem) orderItemService.get(oiid);
	        total +=oi.getProduct().getPromotePrice()*oi.getNumber();
	        orderItems.add(oi);
	        productImageService.setFirstProdutImage(oi.getProduct());
	    }
	      
	    ActionContext.getContext().getSession().put("orderItems", orderItems);
		return "settleAccount";
	}
	
	//���빺�ﳵ
	@Action("foreaddCart")
	public String addCart() {
	    User user =(User) ActionContext.getContext().getSession().get("user");
	    boolean found = false;
	    List<OrderItem> ois = orderItemService.list("user",user,"order", null);
	    for (OrderItem oi : ois) {
	        if(oi.getProduct().getId()==product.getId()){
	            oi.setNumber(oi.getNumber()+num);
	            orderItemService.update(oi);
	            found = true;
	            break;
	        }
	    }      
	      
	    if(!found){
	        OrderItem oi = new OrderItem();
	        oi.setUser(user);
	        oi.setNumber(num);
	        oi.setProduct(product);
	        orderItemService.save(oi);
	    }
	    return "success";
	}
	
	//���빺�ﳵ
	@Action("forecart")
	public String cart(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		orderItems = orderItemService.list("user",user,"order",null);
		for (OrderItem orderItem : orderItems)
	        productImageService.setFirstProdutImage(orderItem.getProduct());
		return "shoppingcart";
	}
	
	//���ﳵҳ�޸Ķ���������
	@Action("forechangeOrderItem")
	public String changeOrderItem(){
		User user = (User) ActionContext.getContext().getSession().get("user");
    	if(null==user)
			return "fail";
    	
    	t2p(product);
    	List<OrderItem> ois = orderItemService.list("user",user,"order",null,"product",product);
    	OrderItem oi = ois.get(0);
    	oi.setNumber(num);
    	orderItemService.update(oi);
    	
		return "success";
	}
	
	@Action("foredeleteOrderItem")
    public String deleteOrderItem(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null==user)
			return "fail";
		
        orderItemService.delete(orderItem);
        return "success";
    }
	
	@Action("forecreateOrder")
	public String createOrder(){
	    List<OrderItem> ois= (List<OrderItem>) ActionContext.getContext().getSession().get("orderItems");
	    if(ois.isEmpty())
	        return "loginPage";
	  
	    User user =(User) ActionContext.getContext().getSession().get("user");
	    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +RandomUtils.nextInt(10000);
	     
	    order.setOrderCode(orderCode);
	    order.setCreateDate(new Date());
	    order.setUser(user);
	    order.setStatus(OrderService.waitPay);
	     
	    total = orderService.createOrder(order, ois);
	    return "payPage";
	}
	
	@Action("forepay")
	public String pay(){
		return "pay";
	}
	
	@Action("forepaysuccess")
	public String paysuccess(){
		t2p(order);
		order.setPayDate(new Date());
		order.setStatus(OrderService.waitDelivery);
		orderService.update(order);
		return "paysuccess";
	}
	
}
