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
			msg = "用户名已经被使用，不能使用";
			user = null;		//如果不把user置空 那么顶部导航栏就判断登陆了该已经被注册的user 虽然只在这一个页面起作用 不过还是不好
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
			msg= "账号密码错误";
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
