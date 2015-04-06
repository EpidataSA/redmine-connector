/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.redmine;

import java.util.Collection;

import org.mule.api.MuleException;
import org.mule.api.MuleRuntimeException;
import org.mule.api.annotations.ConnectionStrategy;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.redmine.strategy.ConnectionManagementStrategy;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.Role;
import com.taskadapter.redmineapi.bean.User;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="redmine", schemaVersion = "1.0", friendlyName="Redmine", minMuleVersion = "3.6")
public class RedmineConnector {
    
    @ConnectionStrategy
    ConnectionManagementStrategy connectionStrategy;

    
    public ConnectionManagementStrategy getConnectionStrategy() {
        return connectionStrategy;
    }

    public void setConnectionStrategy(ConnectionManagementStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }
    
    /**
	 * Build a new connection using a given apiKey.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-issues}
	 *
	 * @param apiAccessKey
	 *            api key for the new connection.
	 */
//	@Processor
//	public void buildNewManager(String apiAccessKey) {
//		connectionStrategy.getClient().buildNewManager(apiAccessKey);		
//	}
	
    /**
	 * Create a new connection using a given username and password.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-issues}
	 *
	 * @param username
	 *            username for the new connection.
	 *            
	 * @param password
	 *            password for the new connection.
	 */
//	@Processor
//	public void changeUser(String username, String password) {
//		connectionStrategy.getClient().changeUser(username, password);	
//	}
    
	//Project processors    
    
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
	 */
	@Processor
	public Collection<Issue> getProjectIssues(String projectKey) throws MuleException {
		try {
			return connectionStrategy.getClient().getIssues(projectKey);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
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
	 */	
	@Processor
	public Project getProjectDetail(String projectKey) throws MuleException {
		try {
			return connectionStrategy.getClient().getProjectDetail(projectKey);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}			
	}
	
    /**
	 * Gets a list of available projects.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-available-projects}
	 *
	 * @return Collection of Project
	 */		
	@Processor
	public Collection<Project> getAvailableProjects() throws MuleException {
		try {
			return connectionStrategy.getClient().getAvailableProjects();
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}			
	}
	
    /**
	 * Gets a list of members of a given project.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-project-members}
	 *
	 * @return Collection of Membership
	 */		
	@Processor
	public Collection<Membership> getProjectMembers(String projectKey) throws MuleException {
		try {
			return connectionStrategy.getClient().getMembers(projectKey);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}		
	}

	
	//User methods
	
    /**
	 * Gets a list of users.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-users}
	 *
	 * @return Collection of User
	 */		
	@Processor
	public Collection<User> getUsers() throws MuleException {
		try {
			return connectionStrategy.getClient().getUsers();
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}		
	}

    /**
	 * Gets a detail for a given user.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-user-detail}
	 *
	 * @return User
	 */		
	@Processor
	public User getUserDetail(Integer userId) throws MuleException {
		try {
			return connectionStrategy.getClient().getUserDetail(userId);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}			
	}

    /**
	 * Gets a list of roles.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-roles}
	 *
	 * @return Collection of Role
	 */		
	@Processor
	public Collection<Role> getRoles() throws MuleException {
		try {
			return connectionStrategy.getClient().getRoles();
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}			
	}

    /**
	 * Gets a detail for a given role.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-role}
	 *
	 * @return Role
	 */		
	@Processor
	public Role getRoleDetail(Integer roleId) throws MuleException {
		try {
			return connectionStrategy.getClient().getRoleDetail(roleId);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}			
	}

    /**
	 * Gets a list of groups.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-groups}
	 *
	 * @return Collection of Group
	 */		
	@Processor
	public Collection<Group> getGroups() throws MuleException {
		try {
			return connectionStrategy.getClient().getGroups();
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}
	}

    /**
	 * Gets a detail for a given group.
	 *
	 * {@sample.xml ../../../doc/redmine-connector.xml.sample
	 * redmine:get-group-detail}
	 *
	 * @return Collection of Group
	 */		
	@Processor
	public Group getGroupDetail(Integer groupId) throws MuleException {		
		try {
			return connectionStrategy.getClient().getGroupDetail(groupId);
		} catch (RedmineException ex) {
			throw new MuleRuntimeException(ex);
		}		
	}
}