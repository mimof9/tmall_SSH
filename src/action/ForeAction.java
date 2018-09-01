package action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

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
			return "register";
		}
		userService.save(user);
		return "registerSuccess";
	}
	
}
