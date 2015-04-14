/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.automation.RedmineTestParent;
import org.mule.modules.automation.RegressionTests;
import org.mule.modules.automation.SmokeTests;
import org.springframework.util.Assert;

import com.taskadapter.redmineapi.bean.Project;

public class GetProjectDetailTestCases
    extends RedmineTestParent
{

    @Before
    public void setup()
        throws Exception
    {
        //TODO: Add setup required to run test or remove method
        initializeTestRunMessage("getProjectDetailTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {
        //TODO: Add code to reset sandbox state to the one before the test was run or remove
    }

    @Category({
        RegressionTests.class,
        SmokeTests.class
    })
    @Test
    public void testGetProjectDetail()
        throws Exception
    {
        Project project = runFlowAndGetPayload("get-project-detail");
        Assert.notNull(project);
        Assert.isTrue(project.getIdentifier().contentEquals("operacionesproyectos"));
        Assert.isTrue(project.getName().contentEquals("Proyectos"));
        Assert.isTrue(project.getDescription().contentEquals(""));
		Assert.isTrue(project.getHomepage().contentEquals(""));
		Assert.notNull(project.getTrackers());
		Assert.isTrue(project.getTrackerByName("story").getId()==6);
		Assert.isTrue(project.getTrackerByName("Evento de proyecto").getId()==25);
		Assert.isTrue(project.getTrackerByName("Hito proyecto").getId()==24);
		Assert.isNull(project.getParentId());
    }

}
