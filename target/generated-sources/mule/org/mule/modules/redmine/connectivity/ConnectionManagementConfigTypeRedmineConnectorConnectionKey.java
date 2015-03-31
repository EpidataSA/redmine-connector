
package org.mule.modules.redmine.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionKey;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-31T07:38:35-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ConnectionManagementConfigTypeRedmineConnectorConnectionKey implements ConnectionManagementConnectionKey
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;

    public ConnectionManagementConfigTypeRedmineConnectorConnectionKey(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    @Override
    public int hashCode() {
        int result = ((this.username!= null)?this.username.hashCode(): 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionManagementConfigTypeRedmineConnectorConnectionKey)) {
            return false;
        }
        ConnectionManagementConfigTypeRedmineConnectorConnectionKey that = ((ConnectionManagementConfigTypeRedmineConnectorConnectionKey) o);
        if (((this.username!= null)?(!this.username.equals(that.username)):(that.username!= null))) {
            return false;
        }
        return true;
    }

}
