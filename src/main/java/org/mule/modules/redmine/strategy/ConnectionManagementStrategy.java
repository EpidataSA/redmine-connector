/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.redmine.strategy;

import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.client.RedmineClient;

/**
 * Configuration Management Strategy
 *
 * @author MuleSoft, Inc.
 */
@ConnectionManagement(configElementName = "config-type", friendlyName = "Configuration type strategy")
public class ConnectionManagementStrategy {
	
	/**
	 * Client to consume API
	 */
	private RedmineClient client;
	
    /**
     * Configurable
     */
    @Configurable
	@Placement(group = "Connection")    
    private String uri;

    /**
     * Configurable
     */
    @Configurable
    @Placement(group = "Connection")    
    private String apiAccessKey;
    
    
    /**
     * Set uri property
     *
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Get uri property
     */
    public String getUri() {
        return this.uri;
    }

    /**
     * Set apiAccessKey property
     *
     * @param apiAccessKey
     */
    public void setApiAccessKey(String apiAccessKey) {
        this.apiAccessKey = apiAccessKey;
    }

    /**
     * Get apiAccessKey property
     */
    public String getApiAccessKey() {
        return this.apiAccessKey;
    }    
    
	/**
	 * Get Redmine client
	 * @return RedmineClient
	 */
	public RedmineClient getClient() {
		if (this.client == null) {
			this.client = new RedmineClient(this.uri, this.apiAccessKey);
		}
		
		return this.client;
	}
	
	/**
	 * Connect
	 * 
	 * @throws ConnectionException
	 */
	@Connect
	@TestConnectivity
	public void connect(@Optional @ConnectionKey String username, @Optional @Password String password) throws ConnectionException {
		testConnectivity(username, password);
	}

	/**
	 * Id for the connection
	 */
	@ConnectionIdentifier
	public String connectionId() {
		return "001";
	}
	
	/**
	 * Are we connected
	 */
	@ValidateConnection
	public boolean validateConnection() {
		return (this.client != null);
	}

	/**
	 * Disconnect
	 */
	@Disconnect
	public void disconnect() {
		this.client = null;
	}

	/**
	 * Checks if credentials are valid
	 *
	 * @param username
	 *            A username (optional)
	 * @param password
	 *            A password (optional)
	 * @throws ConnectionException
	 */
	@TestConnectivity
	public void testConnectivity(String username, String password) throws ConnectionException {
		
		this.client = new RedmineClient(this.uri, this.apiAccessKey);
		
		if (username != null && password != null) {
			this.client.changeUser(username, password);
		}
	
		if (client == null) {
			throw new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, 
										   "Invalid credentials", "Invalid credentials");
		}
	}
}