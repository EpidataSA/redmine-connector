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

import com.taskadapter.redmineapi.bean.User;

public class GetUserDetailTestCases
    extends RedmineTestParent
{

    @Before
    public void setup()
        throws Exception
    {
        initializeTestRunMessage("getUserDetailTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {
    }

    @Test
    public void testGetUserDetail()
        throws Exception
    {
        User user = runFlowAndGetPayload("get-user-detail");
        Assert.notNull(user);
        Assert.isTrue(user.getId() == 15);
        Assert.isTrue(user.getFirstName().contentEquals("Ana Paula"));
        Assert.isTrue(user.getLastName().contentEquals("Lo Turco"));
		Assert.isTrue(user.getMail().contentEquals("anapaulal@epidataconsulting.com"));
		Assert.notNull(user.getMemberships());
    
    }

}
