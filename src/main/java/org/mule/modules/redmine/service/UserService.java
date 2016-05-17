/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
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
