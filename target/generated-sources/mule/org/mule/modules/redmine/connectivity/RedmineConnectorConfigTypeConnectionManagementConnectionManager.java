
package org.mule.modules.redmine.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.common.DefaultTestResult;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionManager;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectorAdapter;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectorFactory;
import org.mule.devkit.shade.connection.management.ConnectionManagementProcessTemplate;
import org.mule.devkit.shade.connection.management.UnableToAcquireConnectionException;
import org.mule.devkit.shade.connectivity.ConnectivityTestingErrorHandler;
import org.mule.modules.redmine.RedmineConnector;
import org.mule.modules.redmine.adapters.RedmineConnectorConnectionManagementAdapter;
import org.mule.modules.redmine.pooling.DevkitGenericKeyedObjectPool;
import org.mule.modules.redmine.strategy.ConnectionManagementStrategy;


/**
 * A {@code RedmineConnectorConfigTypeConnectionManagementConnectionManager} is a wrapper around {@link RedmineConnector } that adds connection management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-31T07:38:35-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RedmineConnectorConfigTypeConnectionManagementConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<RedmineConnectorConnectionManagementAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManagementConnectionManager<ConnectionManagementConfigTypeRedmineConnectorConnectionKey, RedmineConnectorConnectionManagementAdapter, ConnectionManagementStrategy>
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    private String uri;
    private String apiAccessKey;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Redmine";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.6.1";
    private final static String DEVKIT_BUILD = "UNNAMED.2405.44720b7";
    private final static String MIN_MULE_VERSION = "3.6";

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

    /**
     * Sets uri
     * 
     * @param value Value to set
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Retrieves uri
     * 
     */
    public String getUri() {
        return this.uri;
    }

    /**
     * Sets apiAccessKey
     * 
     * @param value Value to set
     */
    public void setApiAccessKey(String value) {
        this.apiAccessKey = value;
    }

    /**
     * Retrieves apiAccessKey
     * 
     */
    public String getApiAccessKey() {
        return this.apiAccessKey;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new ConnectionManagementConnectorFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public RedmineConnectorConnectionManagementAdapter acquireConnection(ConnectionManagementConfigTypeRedmineConnectorConnectionKey key)
        throws Exception
    {
        return ((RedmineConnectorConnectionManagementAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(ConnectionManagementConfigTypeRedmineConnectorConnectionKey key, RedmineConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(ConnectionManagementConfigTypeRedmineConnectorConnectionKey key, RedmineConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, RedmineConnectorConnectionManagementAdapter> getProcessTemplate() {
        return new ConnectionManagementProcessTemplate(this, muleContext);
    }

    @Override
    public ConnectionManagementConfigTypeRedmineConnectorConnectionKey getDefaultConnectionKey() {
        return new ConnectionManagementConfigTypeRedmineConnectorConnectionKey(getUsername(), getPassword());
    }

    @Override
    public ConnectionManagementConfigTypeRedmineConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("username").getGenericType(), null, getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method connect can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("password").getGenericType(), null, getPassword()));
            if (_transformedPassword == null) {
                throw new UnableToAcquireConnectionException("Parameter password in method connect can't be null because is not @Optional");
            }
            return new ConnectionManagementConfigTypeRedmineConnectorConnectionKey(_transformedUsername, _transformedPassword);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    @Override
    public ConnectionManagementConfigTypeRedmineConnectorConnectionKey getConnectionKey(MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return getEvaluatedConnectionKey(event);
    }

    @Override
    public ConnectionManagementConnectionAdapter newConnection() {
        ConnectionManagementStrategyRedmineConnectorAdapter connection = new ConnectionManagementStrategyRedmineConnectorAdapter();
        connection.setUri(getUri());
        connection.setApiAccessKey(getApiAccessKey());
        return connection;
    }

    @Override
    public ConnectionManagementConnectorAdapter newConnector(ConnectionManagementConnectionAdapter<ConnectionManagementStrategy, ConnectionManagementConfigTypeRedmineConnectorConnectionKey> connection) {
        RedmineConnectorConnectionManagementAdapter connector = new RedmineConnectorConnectionManagementAdapter();
        connector.setConnectionStrategy(connection.getStrategy());
        return connector;
    }

    public ConnectionManagementConnectionAdapter getConnectionAdapter(ConnectionManagementConnectorAdapter adapter) {
        RedmineConnectorConnectionManagementAdapter connector = ((RedmineConnectorConnectionManagementAdapter) adapter);
        ConnectionManagementConnectionAdapter strategy = ((ConnectionManagementConnectionAdapter) connector.getConnectionStrategy());
        return strategy;
    }

    public TestResult test() {
        RedmineConnectorConnectionManagementAdapter connection = null;
        DefaultTestResult result;
        ConnectionManagementConfigTypeRedmineConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            result = new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            result = ((DefaultTestResult) ConnectivityTestingErrorHandler.buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
        return result;
    }

}
