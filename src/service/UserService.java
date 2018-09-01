package service;

import bean.User;

public interface UserService extends BaseService {
	
	//判断用户名是否存在
	public boolean isExist(String name);
	//判断用户密码
	User get(String name, String password);
}
