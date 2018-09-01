package action;

import java.util.Collections;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionContext;

import bean.User;
import comparator.ProductAllComparator;
import comparator.ProductDateComparator;
import comparator.ProductPriceComparator;
import comparator.ProductReviewComparator;
import comparator.ProductSaleCountComparator;

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
}
