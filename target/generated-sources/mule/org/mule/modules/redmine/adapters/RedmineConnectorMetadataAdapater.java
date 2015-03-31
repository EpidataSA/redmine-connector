
package org.mule.modules.redmine.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.redmine.RedmineConnector;


/**
 * A <code>RedmineConnectorMetadataAdapater</code> is a wrapper around {@link RedmineConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-31T07:38:35-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RedmineConnectorMetadataAdapater
    extends RedmineConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Redmine";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.6.1";
    private final static String DEVKIT_BUILD = "UNNAMED.2405.44720b7";
    private final static String MIN_MULE_VERSION = "3.6";

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

}
