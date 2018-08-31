package action;

import org.apache.struts2.convention.annotation.Action;

import util.Page;

public class UserAction extends Action4Result {
	
	@Action("admin_user_list")
	public String list(){
		if(null == page)
			page = new Page(0,5);
		int total = userService.total();
		page.setTotal(total);
		users = userService.listByPage(page);
		return "listUser";
	}
}
