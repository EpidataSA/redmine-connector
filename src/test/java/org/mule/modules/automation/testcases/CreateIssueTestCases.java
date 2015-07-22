/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.automation.testcases;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.automation.RedmineTestParent;
import org.mule.modules.automation.RegressionTests;
import org.mule.modules.automation.SmokeTests;
import org.springframework.util.Assert;

import com.taskadapter.redmineapi.bean.Issue;

public class CreateIssueTestCases
    extends RedmineTestParent
{


    @Before
    public void setup()
        throws Exception
    {
        initializeTestRunMessage("createIssueTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {

    }

    @Category({
        RegressionTests.class,
        SmokeTests.class
    })
    @Test
    public void testCreateIssue()
        throws Exception
    {
    	Issue result = runFlowAndGetPayload("create-issue");
        Collection<Issue> projectIssues= runFlowAndGetPayload("get-project-issues");
        Assert.notNull(result);
        Assert.isTrue(projectIssues.contains(result));
        Assert.isTrue(result.getSubject().contentEquals("Connector Testing: Creating new Issue"));
        Assert.isTrue(result.getDescription().contentEquals("Connector Testing: Description for the new Issue"));
        Assert.isTrue(result.getPriorityId()==4);
        Assert.isTrue(result.getStatusId()==1);
        Assert.isTrue(result.getStatusName().contentEquals("New"));
    }

}
