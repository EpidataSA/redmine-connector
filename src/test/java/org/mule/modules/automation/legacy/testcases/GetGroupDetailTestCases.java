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

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MessagingException;
import org.mule.modules.automation.legacy.RedmineTestParent;
import org.springframework.util.Assert;

import com.taskadapter.redmineapi.bean.Group;

public class GetGroupDetailTestCases
    extends RedmineTestParent
{

    @Before
    public void setup()
        throws Exception
    {
        initializeTestRunMessage("getGroupDetailTestData");
    }

    @After
    public void tearDown()
        throws Exception
    {
    }

    @Test
    public void testGetGroupDetail()
        throws Exception
    {
       	try {
       		Group group = runFlowAndGetPayload("get-group-detail");   
       		Assert.notNull(group);
          fail( "GetGroups() method should throw a MessagingException because the credentials do not have admin permissions" );
        } catch (MessagingException expectedException) {
        }
    }

}
