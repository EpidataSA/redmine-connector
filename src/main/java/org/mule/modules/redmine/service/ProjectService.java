package org.mule.modules.redmine.service;

import java.util.Collection;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;

public interface ProjectService extends BaseService {

	Collection<Issue> getIssues(String projectKey) throws RedmineException;
	
	Project getProjectDetail(String projectKey) throws RedmineException;
	
	Collection<Project> getAvailableProjects() throws RedmineException;
	
	Collection<Membership> getMembers(String projectKey) throws RedmineException;
}
