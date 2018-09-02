package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Order;
import bean.OrderItem;
import service.OrderItemService;
import service.OrderService;

@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	@Autowired OrderItemService orderItemService;
	
	/*
	 * 1. �Ѷ������뵽���ݿ���
	 * 2. Ϊÿ��OrderItem�����䶩��
	 * 3. �ۼƽ�����(non-Javadoc)
	 */
	//��Ҫ����������
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	@Override
	public float createOrder(Order order, List<OrderItem> ois) {
        save(order);
        float total =0;
        for (OrderItem oi: ois) {
            oi.setOrder(order);
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
	}

}
