package service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
