
package org.mule.modules.redmine.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.modules.redmine.strategy.ConnectionManagementStrategy;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-31T07:38:35-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ConnectionManagementStrategyRedmineConnectorAdapter
    extends ConnectionManagementStrategy
    implements ConnectionManagementConnectionAdapter<ConnectionManagementStrategy, ConnectionManagementConfigTypeRedmineConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigTypeRedmineConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionId();
    }

    @Override
    public boolean isConnected() {
        return super.validateConnection();
    }

    @Override
    public ConnectionManagementStrategy getStrategy() {
        return this;
    }

}
