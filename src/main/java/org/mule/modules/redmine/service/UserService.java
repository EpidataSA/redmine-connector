package org.mule.modules.redmine.service;

import java.util.Collection;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Role;
import com.taskadapter.redmineapi.bean.User;

public interface UserService extends BaseService {

	Collection<User> getUsers() throws RedmineException;

	User getUserDetail(Integer userId) throws RedmineException;

	Collection<Role> getRoles() throws RedmineException;

	Role getRoleDetail(Integer roleId) throws RedmineException;

	Collection<Group> getGroups() throws RedmineException;

	Group getGroupDetail(Integer groupId) throws RedmineException;

}
