
package org.mule.modules.redmine.agents;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang.StringUtils;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.agent.Agent;
import org.mule.api.context.MuleContextAware;
import org.mule.api.registry.Registry;
import org.mule.modules.redmine.devkit.SplashScreenAgent;
import org.mule.util.StringMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Agent implementation to add splash screen information for DevKit extensions at application startup
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-30T04:57:42-03:00", comments = "Build UNNAMED.2405.44720b7")
public class DefaultSplashScreenAgent implements Agent, MuleContextAware, SplashScreenAgent
{

    private int extensionsCount;
    private MuleContext muleContext;
    private static Logger logger = LoggerFactory.getLogger(DefaultSplashScreenAgent.class);

    public void setName(String name) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return "DevKitSplashScreenAgent";
    }

    public String getDescription() {
        return "DevKit Extension Information";
    }

    /**
     * Retrieves extensionsCount
     * 
     */
    public int getExtensionsCount() {
        return this.extensionsCount;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    public void initialise() {
    }

    public void splash() {
        Registry registry = muleContext.getRegistry();
        Collection<MetadataAware> metadataAwares = registry.lookupObjects(MetadataAware.class);
        Map<Class, MetadataAware> metadataAwaresByClass = new HashMap<Class, MetadataAware>();
        for (MetadataAware ***REMOVED***Metadata: metadataAwares) {
            metadataAwaresByClass.put(metadataAwares.getClass(), ***REMOVED***Metadata);
        }
        extensionsCount = metadataAwaresByClass.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((("DevKit Extensions ("+ Integer.toString(extensionsCount))+") used in this application \n"));
        if (extensionsCount > 0) {
            for (MetadataAware ***REMOVED***Metadata: metadataAwaresByClass.values()) {
                stringBuilder.append(StringUtils.capitalise(***REMOVED***Metadata.getModuleName()));
                stringBuilder.append(" ");
                stringBuilder.append(***REMOVED***Metadata.getModuleVersion());
                stringBuilder.append(" (DevKit ");
                stringBuilder.append(***REMOVED***Metadata.getDevkitVersion());
                stringBuilder.append(" Build ");
                stringBuilder.append(***REMOVED***Metadata.getDevkitBuild());
                stringBuilder.append(")+\n");
            }
        }
        logger.info(StringMessageUtils.getBoilerPlate(stringBuilder.toString(), '+', 80));
    }

    public void start() {
        splash();
    }

    public void stop() {
    }

    public void dispose() {
    }

}
