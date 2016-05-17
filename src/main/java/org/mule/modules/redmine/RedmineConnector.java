/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.redmine;

import java.util.Collection;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.redmine.exception.RedmineException;

import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.Role;
import com.taskadapter.redmineapi.bean.User;

/**
 * Redmine is a free and open source, web-based project management and issue tracking tool. 
 * It allows users to manage multiple projects and associated sub-projects.
 * 
 * @author MuleSoft, Inc.
 */
@Connector(name="redmine", schemaVersion = "1.0", friendlyName="Redmine", minMuleVersion = "3.7")
public class RedmineConnector {

	/** The connector's global configuration. **/
	@org.mule.api.annotations.Config
	private Config config;

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

    /**
	 * Gets a list of available projects.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-available-projects}
	 *
	 * @return Collection of Project
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Collection<Project> getAvailableProjects() throws RedmineException {
		try {
			return config.getClient().getAvailableProjects();
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}			
	}
	
    /**
	 * Gets a list of issues for a given project.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-issues}
	 *
	 * @param projectKey
	 *            key for the project needed to get the issues.
	 *
	 * @return Collection of Issue
	 * @throws RedmineException if there is a problem in the execution
	 */
	@Processor
	public Collection<Issue> getProjectIssues(String projectKey) throws RedmineException {
		try {
			return config.getClient().getIssues(projectKey);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}		
	}
	
    /**
	 * Gets a project detail.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-detail}
	 *
	 * @param projectKey
	 *            key for the project needed to get the detail.
	 *
	 * @return Project
	 * @throws RedmineException if there is a problem in the execution
	 */	
	@Processor
	public Project getProjectDetail(String projectKey) throws RedmineException {
		try {
			return config.getClient().getProjectDetail(projectKey);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}			
	}
	
    /**
	 * Gets a list of members of a given project.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-members}
	 *
	 * @param projectKey
	 *            key for the project needed to get the issues.
	 *            
	 * @return Collection of Membership
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Collection<Membership> getProjectMembers(String projectKey) throws RedmineException {
		try {
			return config.getClient().getMembers(projectKey);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}		
	}

    /**
	 * Gets a list of users.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-users}
	 *
	 * @return Collection of User
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Collection<User> getUsers() throws RedmineException {
		try {
			return config.getClient().getUsers();
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}		
	}

    /**
	 * Gets a detail for a given user.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-user-detail}
	 *
	 * @param userId
	 *            id for the user needed to get the detail.
	 *            
	 * @return User
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public User getUserDetail(Integer userId) throws RedmineException {
		try {
			return config.getClient().getUserDetail(userId);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}			
	}

    /**
	 * Gets a list of roles.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-roles}
	 *
	 * @return Collection of Role
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Collection<Role> getRoles() throws RedmineException {
		try {
			return config.getClient().getRoles();
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}			
	}

    /**
	 * Gets a detail for a given role.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-role-detail}
	 *
	 * @param roleId
	 *            id for the role needed to get the detail.
	 *            
	 * @return Role
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Role getRoleDetail(Integer roleId) throws RedmineException {
		try {
			return config.getClient().getRoleDetail(roleId);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}			
	}

    /**
	 * Gets a list of groups.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-groups}
	 *
	 * @return Collection of Group
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Collection<Group> getGroups() throws RedmineException {
		try {
			return config.getClient().getGroups();
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}
	}

    /**
	 * Gets a detail for a given group.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-group-detail}
	 *
	 * @param groupId
	 *            id for the group needed to get the detail.
	 *            
	 * @return Collection of Group
	 * @throws RedmineException if there is a problem in the execution
	 */		
	@Processor
	public Group getGroupDetail(Integer groupId) throws RedmineException {
		try {
			return config.getClient().getGroupDetail(groupId);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}		
	}
	
	/**
	 * Creates a new issue for a given project with a given project Id, subject, description, priority Id, status Id, status name, User asignee, category Id, version Id, parent Id, start and due date, a done ratio and a estimated time.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:create-issue}
	 *
	 * @param projectKey
	 *            key for the project needed to set the new issue.
	 * @param subject
	 *			subject for the new issue to create.
	 * @param description
	 * 			A description of the new issue.
	 * @param priorityId 
	 * 			Id for set the priority for the new issue to create.
	 * @param statusId
	 * 			Id for the status for the new issue to create.
	 * @param statusName
	 * 			name for the status for the new issue to create.
	 * @param assigneeId 
	 * 			Id for for the user needed to set the assignee.
	 * @param categoryId
	 * 			Id for the category needed to set the issue category.
	 * @param versionId
	 * 			Id for the version needed to set the version in the new issue.
	 * @param parentId
	 * 			Id for the parent needed to set the parent in the new issue.
	 * @param startDate
	 *			The Date for the start date of the new issue.
	 * @param dueDate
	 * 			The Date for the start date of the new issue, this date need must be set after the start date.
	 * @param estimatedTime
	 * 			Estimated time of the new issue.
	 * @param doneRatio
	 * 			The percent of the done ratio for the new issue.
	 * @return Issue
	 * @throws RedmineException if there is a problem in the execution
	 */
	@Processor
	public Issue createIssue(String projectKey,
							  String subject,						
							  @Optional String description,
							  Integer priorityId, 
							  Integer statusId,
							  String statusName,
							  @Optional Integer assigneeId,
							  @Optional Integer categoryId,
							  @Optional Integer versionId,
							  @Optional Integer parentId,
							  String startDate,
							  String dueDate,
							  @Optional Float estimatedTime,
							  @Optional Integer doneRatio) throws RedmineException {
		try {
			return config.getClient().createIssue(projectKey, subject, description, priorityId, statusId, statusName, assigneeId, categoryId, versionId, parentId, startDate, dueDate, estimatedTime, doneRatio);
		} catch (com.taskadapter.redmineapi.RedmineException ex) {
			throw new RedmineException(ex);
		}		
	}
	
}