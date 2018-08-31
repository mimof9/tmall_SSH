package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Product;
import bean.Property;
import bean.PropertyValue;
import service.PropertyService;
import service.PropertyValueService;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl implements PropertyValueService {
	
	@Autowired
    PropertyService propertyService;
	
	@Override
	public void init(Product product) {
		// TODO Auto-generated method stub
		List<Property> propertys= propertyService.listByParent(product.getCategory());
        for (Property property: propertys) {
            PropertyValue propertyValue = get(property,product);
            if(null==propertyValue){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                save(propertyValue);
            }
        }
	}
	
	private PropertyValue get(Property property, Product product) {
        List<PropertyValue> result= this.list("property",property, "product",product);
        if(result.isEmpty())
            return null;
        return result.get(0);
    }

}
