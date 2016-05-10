/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
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

	Issue createIssue(String projectKey, String subject, String description,
			Integer priorityId, Integer statusId, String statusName,
			Integer assigneeId, Integer categoryId, Integer versionId,
			Integer parentId, String startDate, String dueDate,
			Float estimatedTime, Integer doneRatio) throws RedmineException;
}
