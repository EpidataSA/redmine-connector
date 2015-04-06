package org.mule.modules.redmine;

import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.redmine.strategy.ConnectionManagementStrategy;

import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.User;

public class ConnectionTest {

private static RedmineConnector ***REMOVED***;
	
	@BeforeClass
	public static void setUp() throws ConnectionException {
		
		ConnectionManagementStrategy strategy = new ConnectionManagementStrategy();
    	
		strategy.setUri("http://192.168.11.243/redmine/");
    	strategy.setApiAccessKey("***REMOVED***");
		
		//strategy.setUri("http://www.epidata.com.ar/redmine");
    	//strategy.setApiAccessKey("748aa2994933da6f4da7d2d8356f7fa4f11f83aa");
    	
    	//strategy.setUri("https://www.hostedredmine.com");
    	//strategy.setApiAccessKey("a3221bfcef5750219bd0a2df69519416dba17fc9");
    	
    	strategy.connect("***REMOVED***", "***REMOVED***");
    	
    	***REMOVED*** = new RedmineConnector();
		***REMOVED***.setConnectionStrategy(strategy);
	}
	
	@Test
	public void validate() throws Exception {
		Collection<Project> projects = ***REMOVED***.getAvailableProjects();
		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}
}
