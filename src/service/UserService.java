package service;

public interface UserService extends BaseService {
	
	//判断用户名是否存在
	public boolean isExist(String name);
}
