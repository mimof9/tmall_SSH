package service;

import java.util.List;

import bean.Order;

public interface OrderItemService extends BaseService {
	
	//这两个是填充订单的方法
	public void fill(List<Order> orders);
    public void fill(Order order);
    
}
