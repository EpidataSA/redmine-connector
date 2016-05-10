/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.redmine.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.mule.modules.redmine.service.ProjectService;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.NotAuthorizedException;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.IssueCategory;
import com.taskadapter.redmineapi.bean.IssueCategoryFactory;
import com.taskadapter.redmineapi.bean.IssueFactory;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.User;
import com.taskadapter.redmineapi.bean.UserFactory;
import com.taskadapter.redmineapi.bean.Version;
import com.taskadapter.redmineapi.bean.VersionFactory;

public class ProjectServiceImpl extends BaseServiceImpl implements
		ProjectService {

	public ProjectServiceImpl(String uri, String apiAccessKey) {
		super(uri, apiAccessKey);
	}

	@Override
	public Collection<Issue> getIssues(String projectKey)
			throws RedmineException {
		Integer queryId = null;
		return this.manager.getIssueManager().getIssues(projectKey, queryId);
	}

	@Override
	public Project getProjectDetail(String projectKey) throws RedmineException {
		return this.manager.getProjectManager().getProjectByKey(projectKey);
	}

	@Override
	public Collection<Project> getAvailableProjects() throws RedmineException {
		return this.manager.getProjectManager().getProjects();
	}

	@Override
	public Collection<Membership> getMembers(String projectKey)
			throws RedmineException {
		List<Membership> memberships = this.manager.getMembershipManager()
				.getMemberships(projectKey);

		List<Membership> result = new ArrayList<Membership>();

		for (Membership membership : memberships) {
			if (membership.getUser() != null) {
				result.add(membership);
			}
		}

		return result;
	}

	@Override
	public Issue createIssue(String projectKey, String subject,
			String description, Integer priorityId, Integer statusId,
			String statusName, Integer assigneeId, Integer categoryId,
			Integer versionId, Integer parentId, String startDate,
			String dueDate, Float estimatedTime, Integer doneRatio)
			throws RedmineException {
		try {
			Issue issueToCreate = IssueFactory.createWithSubject(subject);
			IssueManager issueManager = this.manager.getIssueManager();
			Project project = this.manager.getProjectManager().getProjectByKey(
					projectKey);
			
			// Obtaining version
			Version version = VersionFactory.create(versionId);
			
			// Obtaining category 
			IssueCategory category = IssueCategoryFactory.create(categoryId);
			
			// Obtaining assignee
			User assignee = UserFactory.create(assigneeId);
	
			// startDate and dueDate from String to Date
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
			Date dateStartDate = null;
			Date dateDueDate = null;
			try {
				dateStartDate = formatter.parse(startDate);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			try {
				dateDueDate = formatter.parse(dueDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
			issueToCreate.setProject(project);
			issueToCreate.setDescription(description);
			issueToCreate.setPriorityId(priorityId);
			issueToCreate.setStatusId(statusId);
			issueToCreate.setStatusName(statusName);
			issueToCreate.setAssignee(assignee);
			issueToCreate.setCategory(category);
			issueToCreate.setTargetVersion(version);
			issueToCreate.setParentId(parentId);
			issueToCreate.setStartDate(dateStartDate);
			issueToCreate.setDueDate(dateDueDate);
			issueToCreate.setEstimatedHours(estimatedTime);
			issueToCreate.setDoneRatio(doneRatio);

			Issue createdIssue = issueManager.createIssue(issueToCreate);
			return createdIssue;
		} catch (NotAuthorizedException e) {
			throw new NotAuthorizedException("Not valid credentials for this operation");
		}
	}
}