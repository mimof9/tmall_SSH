package service;

import java.util.List;

import bean.Order;

public interface OrderItemService extends BaseService {
	
	//����������䶩���ķ���
	public void fill(List<Order> orders);
    public void fill(Order order);
    
}
