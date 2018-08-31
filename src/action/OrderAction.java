package action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import service.OrderService;
import util.Page;

public class OrderAction extends Action4Result {
	
	@Action("admin_order_list")
	public String list(){
		if(null == page)
			page = new Page(0,5);
		int total = orderService.total();
		page.setTotal(total);
		
		orders = orderService.listByPage(page);
		
		orderItemService.fill(orders);
		
		return "listOrder";
	}
	
	@Action("admin_order_delivery")
	public String delivery(){
		t2p(order);
	    order.setDeliveryDate(new Date());
	    order.setStatus(OrderService.waitConfirm);
	    orderService.update(order);
		
		return "listOrderPage";
	}
	
}
