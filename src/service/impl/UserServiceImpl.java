package service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import bean.User;
import service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public boolean isExist(String name) {
		List l = list("name",name);
		if(l.isEmpty())
			return false;
		return true;
	}

	@Override
	public User get(String name, String password) {
		List<User> l = list("name",name,"password",password);
		if(l.isEmpty())
			return null;
		return l.get(0);
	}

}
