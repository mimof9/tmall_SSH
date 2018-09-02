package action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	//�������
	@Result(name="listCategory",location="/admin/listCategory.jsp"),
	@Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
	@Result(name="editCategory", location="/admin/editCategory.jsp"),
	//���Թ���
	@Result(name="listProperty", location="/admin/listProperty.jsp"),
	@Result(name="listPropertyPage", type = "redirect", location="/admin_property_list?category.id=${property.category.id}"),
	@Result(name="editProperty", location="/admin/editProperty.jsp"),
	//��Ʒ����
	@Result(name="listProduct", location="/admin/listProduct.jsp"),
	@Result(name="listProductPage", type = "redirect", location="/admin_product_list?category.id=${product.category.id}"),
	@Result(name="editProduct", location="/admin/editProduct.jsp"),
	//��ƷͼƬ����
	@Result(name="listProductImage", location="/admin/listProductImage.jsp"),
	@Result(name="listProductImagePage", type="redirect", location="/admin_productImage_list?product.id=${productImage.product.id}"),
	//����ֵ����
	@Result(name="editPropertyValue", location="/admin/editPropertyValue.jsp"),
	@Result(name="editPropertyValuePage", type="redirect", location="/admin_propertyValue_edit?product.id=${propertyValue.product.id}"),
	//�û�����
	@Result(name="listUser", location="/admin/listUser.jsp"),
	//��������
	@Result(name="listOrder", location="/admin/listOrder.jsp"),
	@Result(name="listOrderPage", type="redirect", location="/admin_order_list"),
	
	//��ҳ
	@Result(name="home", location="/fore/homePage.jsp"),
	@Result(name="homePage", type="redirect", location="/forehome"),
	//ע��
	@Result(name="registerPage", location="/fore/registerPage.jsp"),
	@Result(name="registerSuccessPage", type="redirect", location="/fore/registerSuccessPage.jsp"),
	//��½
	@Result(name="loginPage", location="/fore/loginPage.jsp"),
	//��Ʒ
	@Result(name="product", location="/fore/productPage.jsp"),
	
	//���سɹ� ʧ��
	@Result(name="success", location="/success.jsp"),
	@Result(name="fail", location="/fail.jsp"),
	
	//����
	@Result(name="category", location="/fore/categoryPage.jsp"),
	//����
	@Result(name="searchResult", location="/fore/searchResultPage.jsp"),
	//����
	@Result(name="settleAccount", location="/fore/settleAccountPage.jsp"),
	@Result(name="settleAccountPage", type="redirect", location="/foresettle?oiids=${oiid}"),
	//���ﳵ
	@Result(name="shoppingcart", location="/fore/shoppingcartPage.jsp"),
	//֧��ҳ
	@Result(name="pay", location="/fore/payPage.jsp"),
	@Result(name="payPage", type="redirect", location="/forepay?total=${total}"),
	//֧���ɹ�ҳ
	@Result(name="paysuccess", location="/fore/paySuccessPage.jsp"),
	//�ҵĶ���
	@Result(name="myorder", location="/fore/myorderPage.jsp"),
	//ȷ���ջ�
	@Result(name="confirmPay", location="/fore/confirmPage.jsp"),
	//ȷ���ջ��ɹ� ȷ���ջ��� ��ת��finished ���Ƕ���״̬�ǵȴ�����
	@Result(name="orderfinished", location="/fore/orderFinishedPage.jsp"),
	//����
	@Result(name="review", location="/fore/reviewPage.jsp"),
	@Result(name="reviewPage", type="redirect", location="/forereview?order.id=${order.id}&showonly=${showonly}"),
	
	
	})
public class Action4Result extends Action4Parameter{
	
}
