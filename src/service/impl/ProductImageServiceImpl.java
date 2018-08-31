package service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import bean.Product;
import bean.ProductImage;
import service.ProductImageService;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService {

	//查询某个产品下的，某种类型的图片。
//	@Override
//	public List<ProductImage> list(String key_product, Product product, String key_type, String type) {
//		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
//        dc.add(Restrictions.eq(key_product, product));
//        dc.add(Restrictions.eq(key_type, type));
//        dc.addOrder(Order.desc("id"));
//        return this.findByCriteria(dc);
//	}

	@Override
	public void setFirstProdutImage(Product product) {
		if(null!=product.getFirstProductImage())
            return;
        List<ProductImage> pis= list("product", product, "type", ProductImageService.type_single);
        if(!pis.isEmpty())
            product.setFirstProductImage(pis.get(0));
	}

}
