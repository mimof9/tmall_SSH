package service;

import bean.User;

public interface UserService extends BaseService {
	
	//�ж��û����Ƿ����
	public boolean isExist(String name);
	//�ж��û�����
	User get(String name, String password);
}
