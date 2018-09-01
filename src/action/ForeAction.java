package action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionContext;

import bean.User;

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
}
