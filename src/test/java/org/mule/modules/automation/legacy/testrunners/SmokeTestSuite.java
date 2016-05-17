/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.automation.legacy.testrunners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mule.modules.automation.legacy.testcases.CreateIssueTestCases;
import org.mule.modules.automation.legacy.testcases.GetAvailableProjectsTestCases;
import org.mule.modules.automation.legacy.testcases.GetGroupDetailTestCases;
import org.mule.modules.automation.legacy.testcases.GetGroupsTestCases;
import org.mule.modules.automation.legacy.testcases.GetProjectDetailTestCases;
import org.mule.modules.automation.legacy.testcases.GetProjectIssuesTestCases;
import org.mule.modules.automation.legacy.testcases.GetProjectMembersTestCases;
import org.mule.modules.automation.legacy.testcases.GetRoleDetailTestCases;
import org.mule.modules.automation.legacy.testcases.GetRolesTestCases;
import org.mule.modules.automation.legacy.testcases.GetUserDetailTestCases;
import org.mule.modules.automation.legacy.testcases.GetUsersTestCases;

@RunWith(org.junit.experimental.categories.Categories.class)
@Suite.SuiteClasses({
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
public class SmokeTestSuite {


}
