package org.mule.modules.redmine.service.impl;

import java.util.Collection;

import org.mule.modules.redmine.service.UserService;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Role;
import com.taskadapter.redmineapi.bean.User;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	public UserServiceImpl(String uri, String apiAccessKey) {
		super(uri, apiAccessKey);
	}

	@Override
	public Collection<User> getUsers() throws RedmineException{
		return this.manager.getUserManager().getUsers();
	}

	@Override
	public User getUserDetail(Integer userId) throws RedmineException{
		return this.manager.getUserManager().getUserById(userId);
	}
	
	@Override
	public Collection<Role> getRoles() throws RedmineException{
		return this.manager.getUserManager().getRoles();
	}

	@Override
	public Role getRoleDetail(Integer roleId) throws RedmineException{
		return this.manager.getUserManager().getRoleById(roleId);
	}
	
	@Override
	public Collection<Group> getGroups() throws RedmineException{
		return this.manager.getUserManager().getGroups();
	}

	@Override
	public Group getGroupDetail(Integer groupId) throws RedmineException{
		return this.manager.getUserManager().getGroupById(groupId);
	}
}
