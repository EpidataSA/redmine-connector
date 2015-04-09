/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.redmine;

import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.redmine.strategy.ConnectionManagementStrategy;

import com.taskadapter.redmineapi.bean.Project;

public class ConnectionTest {

private static RedmineConnector connector;
	
	@BeforeClass
	public static void setUp() throws ConnectionException {
		
		ConnectionManagementStrategy strategy = new ConnectionManagementStrategy();
    	
		strategy.setUri("http://192.168.11.243/redmine/");
    	strategy.setApiAccessKey("7513fa5acffa66604a8736a7cc2d8d2dad110118");
		
		//strategy.setUri("http://www.epidata.com.ar/redmine");
    	//strategy.setApiAccessKey("748aa2994933da6f4da7d2d8356f7fa4f11f83aa");
    	
    	//strategy.setUri("https://www.hostedredmine.com");
    	//strategy.setApiAccessKey("a3221bfcef5750219bd0a2df69519416dba17fc9");
    	
    	strategy.connect("connector", "epipass");
    	
    	connector = new RedmineConnector();
		connector.setConnectionStrategy(strategy);
	}
	
	@Test
	public void validate() throws Exception {
		Collection<Project> projects = connector.getAvailableProjects();
		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}
}
