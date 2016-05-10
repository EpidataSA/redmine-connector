/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.automation.legacy.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.automation.legacy.RedmineTestParent;
import org.springframework.util.Assert;

import com.taskadapter.redmineapi.bean.Project;

public class GetProjectDetailTestCases
    extends RedmineTestParent
{

    @Before
    public void setup()
        throws Exception
    {
        initializeTestRunMessage("getProjectDetailTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {
    }

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
