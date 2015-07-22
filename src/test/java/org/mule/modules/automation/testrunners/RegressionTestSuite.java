/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.automation.testrunners;

import org.junit.runner.RunWith;
import org.mule.modules.automation.RegressionTests;
import org.mule.modules.automation.testcases.CreateIssueTestCases;
import org.mule.modules.automation.testcases.GetAvailableProjectsTestCases;
import org.mule.modules.automation.testcases.GetGroupDetailTestCases;
import org.mule.modules.automation.testcases.GetGroupsTestCases;
import org.mule.modules.automation.testcases.GetProjectDetailTestCases;
import org.mule.modules.automation.testcases.GetProjectIssuesTestCases;
import org.mule.modules.automation.testcases.GetProjectMembersTestCases;
import org.mule.modules.automation.testcases.GetRoleDetailTestCases;
import org.mule.modules.automation.testcases.GetRolesTestCases;
import org.mule.modules.automation.testcases.GetUserDetailTestCases;
import org.mule.modules.automation.testcases.GetUsersTestCases;

@RunWith(org.junit.experimental.categories.Categories.class)
@org.junit.experimental.categories.Categories.IncludeCategory(RegressionTests.class)
@org.junit.runners.Suite.SuiteClasses({
    CreateIssueTestCases.class,
    GetAvailableProjectsTestCases.class,
    GetProjectIssuesTestCases.class,
    GetProjectDetailTestCases.class,
    GetProjectMembersTestCases.class,
    GetUsersTestCases.class,
    GetUserDetailTestCases.class,
    GetRolesTestCases.class,
    GetRoleDetailTestCases.class,
    GetGroupsTestCases.class,
    GetGroupDetailTestCases.class
})
public class RegressionTestSuite {


}
