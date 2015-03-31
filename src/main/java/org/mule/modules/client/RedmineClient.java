package org.mule.modules.client;

import java.util.Collection;

import org.mule.modules.redmine.service.ProjectService;
import org.mule.modules.redmine.service.UserService;
import org.mule.modules.redmine.service.impl.ProjectServiceImpl;
import org.mule.modules.redmine.service.impl.UserServiceImpl;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.Role;
import com.taskadapter.redmineapi.bean.User;

public class RedmineClient {

	//Project service for Redmine
	private ProjectService projectService;
	
	//User service for Redmine
	private UserService userService;
	
	
	public RedmineClient(String uri, String apiAccessKey) {
		projectService = new ProjectServiceImpl(uri, apiAccessKey);
		userService = new UserServiceImpl(uri, apiAccessKey);
	}

	//Project methods
	public Collection<Issue> getIssues(String projectKey) throws RedmineException {
		return projectService.getIssues(projectKey);
	}
	
	public Project getProjectDetail(String projectKey) throws RedmineException {
		return projectService.getProjectDetail(projectKey);
	}
	
	public Collection<Project> getAvailableProjects() throws RedmineException {
		return projectService.getAvailableProjects();
	}
	
	public Collection<Membership> getMembers(String projectKey) throws RedmineException {
		return projectService.getMembers(projectKey);
	}

	//User methods
	public Collection<User> getUsers() throws RedmineException {
		return userService.getUsers();
	}

	public User getUserDetail(Integer userId) throws RedmineException {
		return userService.getUserDetail(userId);
	}

	public Collection<Role> getRoles() throws RedmineException {
		return userService.getRoles();
	}

	public Role getRoleDetail(Integer roleId) throws RedmineException {
		return userService.getRoleDetail(roleId);
	}

	public Collection<Group> getGroups() throws RedmineException {
		return userService.getGroups();
	}

	public Group getGroupDetail(Integer groupId) throws RedmineException {
		return userService.getGroupDetail(groupId);
	}
}
