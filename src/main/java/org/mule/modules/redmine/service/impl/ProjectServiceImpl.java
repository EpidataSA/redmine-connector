package org.mule.modules.redmine.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mule.modules.redmine.service.ProjectService;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;

public class ProjectServiceImpl extends BaseServiceImpl implements ProjectService {

	public ProjectServiceImpl(String uri, String apiAccessKey) {
		super(uri, apiAccessKey);
	}
	
	@Override
	public Collection<Issue> getIssues(String projectKey) throws RedmineException{
		Integer queryId = null;
		return this.manager.getIssueManager().getIssues(projectKey, queryId);
	}
	
	@Override
	public Project getProjectDetail(String projectKey) throws RedmineException{
		return this.manager.getProjectManager().getProjectByKey(projectKey);
	}
	
	@Override
	public Collection<Project> getAvailableProjects() throws RedmineException{
		return this.manager.getProjectManager().getProjects();
	}
	
	@Override
	public Collection<Membership> getMembers(String projectKey) throws RedmineException{
		List<Membership> memberships = this.manager.getMembershipManager().getMemberships(projectKey);
		
		List<Membership> result = new ArrayList<Membership>();
		
		for (Membership membership : memberships) {
			if (membership.getUser() != null) {
				result.add(membership);
			}
		}
		
		return result;
	}
}
