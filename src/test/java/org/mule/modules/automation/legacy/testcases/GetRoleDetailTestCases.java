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

import com.taskadapter.redmineapi.bean.Role;

public class GetRoleDetailTestCases
    extends RedmineTestParent
{

    @Before
    public void setup()
        throws Exception
    {
        initializeTestRunMessage("getRoleDetailTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {
    }

    @Test
    public void testGetRoleDetail()
        throws Exception
    {
        Role role = runFlowAndGetPayload("get-role-detail");
        Assert.notNull(role);
        Assert.isTrue(role.getId() == 3);
        Assert.isTrue(!role.getInherited());
        Assert.isTrue(role.getName().contentEquals("Manager"));
        Assert.notNull(role.getPermissions());
    }

}
