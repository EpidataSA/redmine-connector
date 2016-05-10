/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.automation.system;


import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.redmine.Config;
import org.mule.tools.devkit.ctf.configuration.util.ConfigurationUtils;
import org.mule.tools.devkit.ctf.exceptions.ConfigurationLoadingFailedException;

import java.util.Properties;

public class ConfigTestCases {

    private Config config;

    @Before
    public void before() throws ConfigurationLoadingFailedException {
        final Properties prop = ConfigurationUtils.getAutomationCredentialsProperties();
        config = new Config();
        //config.setUsername(prop.getProperty("config.username"));
        //config.setPassword(prop.getProperty("config.password"));
        config.setUri(prop.getProperty("config.uri"));
        config.setApiAccessKey(prop.getProperty("config.apiAccessKey"));

    }

    @Test
    public void testValidConnection() throws ConnectionException {
        config.testConnectivity("", "");
    }
}
